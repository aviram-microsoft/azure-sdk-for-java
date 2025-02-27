// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.security.keyvault.secrets.implementation;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.Patch;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnValueWireType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.Page;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.LongRunningOperationStatus;
import com.azure.core.util.polling.PollingContext;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.polling.SyncPoller;
import com.azure.security.keyvault.secrets.SecretServiceVersion;
import com.azure.security.keyvault.secrets.models.DeletedSecret;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.azure.security.keyvault.secrets.models.SecretProperties;
import reactor.core.publisher.Mono;

import java.net.HttpURLConnection;
import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;

import static com.azure.core.util.FluxUtil.monoError;
import static com.azure.core.util.FluxUtil.withContext;
import static com.azure.core.util.tracing.Tracer.AZ_TRACING_NAMESPACE_KEY;

public class SecretClientImpl {
    static final String ACCEPT_LANGUAGE = "en-US";
    static final int DEFAULT_MAX_PAGE_RESULTS = 25;
    static final String CONTENT_TYPE_HEADER_VALUE = "application/json";
    // Please see <a href=https://docs.microsoft.com/azure/azure-resource-manager/management/azure-services-resource-providers>here</a>
    // for more information on Azure resource provider namespaces.
    private static final String KEYVAULT_TRACING_NAMESPACE_VALUE = "Microsoft.KeyVault";
    private static final String HTTP_REST_PROXY_SYNC_PROXY_ENABLE = "com.azure.core.http.restproxy.syncproxy.enable";

    private static final Duration DEFAULT_POLLING_INTERVAL = Duration.ofSeconds(1);

    private final String vaultUrl;
    private final SecretService service;
    private final ClientLogger logger = new ClientLogger(SecretClientImpl.class);
    private final HttpPipeline pipeline;
    private final SecretServiceVersion secretServiceVersion;

    /**
     * Creates a {@link SecretClientImpl} that uses an {@link HttpPipeline} to service requests.
     *
     * @param vaultUrl URL for the Azure KeyVault service.
     * @param pipeline {@link HttpPipeline} that the HTTP requests and responses flow through.
     * @param secretServiceVersion {@link SecretServiceVersion} of the service to be used when making requests.
     */
    public SecretClientImpl(String vaultUrl, HttpPipeline pipeline, SecretServiceVersion secretServiceVersion) {
        Objects.requireNonNull(vaultUrl,
            KeyVaultErrorCodeStrings.getErrorString(KeyVaultErrorCodeStrings.VAULT_END_POINT_REQUIRED));

        this.vaultUrl = vaultUrl;
        this.service = RestProxy.create(SecretService.class, pipeline);
        this.pipeline = pipeline;
        this.secretServiceVersion = secretServiceVersion;
    }

    /**
     * Gets the vault endpoint URL to which service requests are sent to.
     *
     * @return The vault endpoint URL.
     */
    public String getVaultUrl() {
        return vaultUrl;
    }

    /**
     * Gets the {@link HttpPipeline} powering this client.
     *
     * @return The {@link HttpPipeline pipeline}.
     */
    public HttpPipeline getHttpPipeline() {
        return this.pipeline;
    }

    /**
     * Gets the default polling interval for long running operations.
     *
     * @return The default polling interval for long running operations
     */
    public Duration getDefaultPollingInterval() {
        return DEFAULT_POLLING_INTERVAL;
    }

    /**
     * The interface defining all the services for {@link SecretClientImpl} to be used by the proxy service to perform
     * REST calls.
     *
     * This is package-private so that these REST calls are transparent to the user.
     */
    @Host("{url}")
    @ServiceInterface(name = "KeyVault")
    public interface SecretService {
        @Put("secrets/{secret-name}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {400}, value = ResourceModifiedException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<KeyVaultSecret>> setSecretAsync(@HostParam("url") String url,
                                                      @PathParam("secret-name") String secretName,
                                                      @QueryParam("api-version") String apiVersion,
                                                      @HeaderParam("accept-language") String acceptLanguage,
                                                      @BodyParam("application/json") SecretRequestParameters parameters,
                                                      @HeaderParam("Content-Type") String type,
                                                      Context context);

        @Put("secrets/{secret-name}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {400}, value = ResourceModifiedException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<KeyVaultSecret> setSecret(@HostParam("url") String url,
                                           @PathParam("secret-name") String secretName,
                                           @QueryParam("api-version") String apiVersion,
                                           @HeaderParam("accept-language") String acceptLanguage,
                                           @BodyParam("application/json") SecretRequestParameters parameters,
                                           @HeaderParam("Content-Type") String type,
                                           Context context);

        @Get("secrets/{secret-name}/{secret-version}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(code = {403}, value = ResourceModifiedException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<KeyVaultSecret>> getSecretAsync(@HostParam("url") String url,
                                                      @PathParam("secret-name") String secretName,
                                                      @PathParam("secret-version") String secretVersion,
                                                      @QueryParam("api-version") String apiVersion,
                                                      @HeaderParam("accept-language") String acceptLanguage,
                                                      @HeaderParam("Content-Type") String type,
                                                      Context context);

        @Get("secrets/{secret-name}/{secret-version}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(code = {403}, value = ResourceModifiedException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<KeyVaultSecret> getSecret(@HostParam("url") String url,
                                           @PathParam("secret-name") String secretName,
                                           @PathParam("secret-version") String secretVersion,
                                           @QueryParam("api-version") String apiVersion,
                                           @HeaderParam("accept-language") String acceptLanguage,
                                           @HeaderParam("Content-Type") String type,
                                           Context context);

        @Get("secrets/{secret-name}/{secret-version}")
        @ExpectedResponses({200, 404})
        @UnexpectedResponseExceptionType(code = {403}, value = ResourceModifiedException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<KeyVaultSecret>> getSecretPollerAsync(@HostParam("url") String url,
                                                            @PathParam("secret-name") String secretName,
                                                            @PathParam("secret-version") String secretVersion,
                                                            @QueryParam("api-version") String apiVersion,
                                                            @HeaderParam("accept-language") String acceptLanguage,
                                                            @HeaderParam("Content-Type") String type,
                                                            Context context);

        @Get("secrets/{secret-name}/{secret-version}")
        @ExpectedResponses({200, 404})
        @UnexpectedResponseExceptionType(code = {403}, value = ResourceModifiedException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<KeyVaultSecret> getSecretPoller(@HostParam("url") String url,
                                                 @PathParam("secret-name") String secretName,
                                                 @PathParam("secret-version") String secretVersion,
                                                 @QueryParam("api-version") String apiVersion,
                                                 @HeaderParam("accept-language") String acceptLanguage,
                                                 @HeaderParam("Content-Type") String type,
                                                 Context context);

        @Patch("secrets/{secret-name}/{secret-version}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<SecretProperties>> updateSecretAsync(@HostParam("url") String url,
                                                           @PathParam("secret-name") String secretName,
                                                           @PathParam("secret-version") String secretVersion,
                                                           @QueryParam("api-version") String apiVersion,
                                                           @HeaderParam("accept-language") String acceptLanguage,
                                                           @BodyParam("application/json") SecretRequestParameters parameters,
                                                           @HeaderParam("Content-Type") String type,
                                                           Context context);

        @Patch("secrets/{secret-name}/{secret-version}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<SecretProperties> updateSecret(@HostParam("url") String url,
                                                @PathParam("secret-name") String secretName,
                                                @PathParam("secret-version") String secretVersion,
                                                @QueryParam("api-version") String apiVersion,
                                                @HeaderParam("accept-language") String acceptLanguage,
                                                @BodyParam("application/json") SecretRequestParameters parameters,
                                                @HeaderParam("Content-Type") String type,
                                                Context context);

        @Delete("secrets/{secret-name}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<DeletedSecret>> deleteSecretAsync(@HostParam("url") String url,
                                                        @PathParam("secret-name") String secretName,
                                                        @QueryParam("api-version") String apiVersion,
                                                        @HeaderParam("accept-language") String acceptLanguage,
                                                        @HeaderParam("Content-Type") String type,
                                                        Context context);

        @Delete("secrets/{secret-name}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<DeletedSecret> deleteSecret(@HostParam("url") String url,
                                             @PathParam("secret-name") String secretName,
                                             @QueryParam("api-version") String apiVersion,
                                             @HeaderParam("accept-language") String acceptLanguage,
                                             @HeaderParam("Content-Type") String type,
                                             Context context);

        @Get("deletedsecrets/{secret-name}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<DeletedSecret>> getDeletedSecretAsync(@HostParam("url") String url,
                                                            @PathParam("secret-name") String secretName,
                                                            @QueryParam("api-version") String apiVersion,
                                                            @HeaderParam("accept-language") String acceptLanguage,
                                                            @HeaderParam("Content-Type") String type,
                                                            Context context);

        @Get("deletedsecrets/{secret-name}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<DeletedSecret> getDeletedSecret(@HostParam("url") String url,
                                                 @PathParam("secret-name") String secretName,
                                                 @QueryParam("api-version") String apiVersion,
                                                 @HeaderParam("accept-language") String acceptLanguage,
                                                 @HeaderParam("Content-Type") String type,
                                                 Context context);

        @Get("deletedsecrets/{secret-name}")
        @ExpectedResponses({200, 404})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<DeletedSecret>> getDeletedSecretPollerAsync(@HostParam("url") String url,
                                                                  @PathParam("secret-name") String secretName,
                                                                  @QueryParam("api-version") String apiVersion,
                                                                  @HeaderParam("accept-language") String acceptLanguage,
                                                                  @HeaderParam("Content-Type") String type,
                                                                  Context context);

        @Get("deletedsecrets/{secret-name}")
        @ExpectedResponses({200, 404})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<DeletedSecret> getDeletedSecretPoller(@HostParam("url") String url,
                                                       @PathParam("secret-name") String secretName,
                                                       @QueryParam("api-version") String apiVersion,
                                                       @HeaderParam("accept-language") String acceptLanguage,
                                                       @HeaderParam("Content-Type") String type,
                                                       Context context);

        @Delete("deletedsecrets/{secret-name}")
        @ExpectedResponses({204})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<Void>> purgeDeletedSecretAsync(@HostParam("url") String url,
                                                     @PathParam("secret-name") String secretName,
                                                     @QueryParam("api-version") String apiVersion,
                                                     @HeaderParam("accept-language") String acceptLanguage,
                                                     @HeaderParam("Content-Type") String type,
                                                     Context context);

        @Delete("deletedsecrets/{secret-name}")
        @ExpectedResponses({204})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<Void> purgeDeletedSecret(@HostParam("url") String url,
                                          @PathParam("secret-name") String secretName,
                                          @QueryParam("api-version") String apiVersion,
                                          @HeaderParam("accept-language") String acceptLanguage,
                                          @HeaderParam("Content-Type") String type,
                                          Context context);

        @Post("deletedsecrets/{secret-name}/recover")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<KeyVaultSecret>> recoverDeletedSecretAsync(@HostParam("url") String url,
                                                                 @PathParam("secret-name") String secretName,
                                                                 @QueryParam("api-version") String apiVersion,
                                                                 @HeaderParam("accept-language") String acceptLanguage,
                                                                 @HeaderParam("Content-Type") String type,
                                                                 Context context);

        @Post("deletedsecrets/{secret-name}/recover")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<KeyVaultSecret> recoverDeletedSecret(@HostParam("url") String url,
                                                      @PathParam("secret-name") String secretName,
                                                      @QueryParam("api-version") String apiVersion,
                                                      @HeaderParam("accept-language") String acceptLanguage,
                                                      @HeaderParam("Content-Type") String type,
                                                      Context context);

        @Post("secrets/{secret-name}/backup")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<SecretBackup>> backupSecretAsync(@HostParam("url") String url,
                                                       @PathParam("secret-name") String secretName,
                                                       @QueryParam("api-version") String apiVersion,
                                                       @HeaderParam("accept-language") String acceptLanguage,
                                                       @HeaderParam("Content-Type") String type,
                                                       Context context);

        @Post("secrets/{secret-name}/backup")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {404}, value = ResourceNotFoundException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<SecretBackup> backupSecret(@HostParam("url") String url,
                                            @PathParam("secret-name") String secretName,
                                            @QueryParam("api-version") String apiVersion,
                                            @HeaderParam("accept-language") String acceptLanguage,
                                            @HeaderParam("Content-Type") String type,
                                            Context context);

        @Post("secrets/restore")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {400}, value = ResourceModifiedException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<KeyVaultSecret>> restoreSecretAsync(@HostParam("url") String url,
                                                          @QueryParam("api-version") String apiVersion,
                                                          @HeaderParam("accept-language") String acceptLanguage,
                                                          @BodyParam("application/json") SecretRestoreRequestParameters parameters,
                                                          @HeaderParam("Content-Type") String type,
                                                          Context context);

        @Post("secrets/restore")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(code = {400}, value = ResourceModifiedException.class)
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Response<KeyVaultSecret> restoreSecret(@HostParam("url") String url,
                                               @QueryParam("api-version") String apiVersion,
                                               @HeaderParam("accept-language") String acceptLanguage,
                                               @BodyParam("application/json") SecretRestoreRequestParameters parameters,
                                               @HeaderParam("Content-Type") String type,
                                               Context context);

        @Get("secrets")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        @ReturnValueWireType(SecretPropertiesPage.class)
        Mono<PagedResponse<SecretProperties>> getSecretsAsync(@HostParam("url") String url,
                                                              @QueryParam("maxresults") Integer maxresults,
                                                              @QueryParam("api-version") String apiVersion,
                                                              @HeaderParam("accept-language") String acceptLanguage,
                                                              @HeaderParam("Content-Type") String type,
                                                              Context context);

        @Get("secrets")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        @ReturnValueWireType(SecretPropertiesPage.class)
        PagedResponse<SecretProperties> getSecrets(@HostParam("url") String url,
                                                   @QueryParam("maxresults") Integer maxresults,
                                                   @QueryParam("api-version") String apiVersion,
                                                   @HeaderParam("accept-language") String acceptLanguage,
                                                   @HeaderParam("Content-Type") String type,
                                                   Context context);

        @Get("secrets/{secret-name}/versions")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        @ReturnValueWireType(SecretPropertiesPage.class)
        Mono<PagedResponse<SecretProperties>> getSecretVersionsAsync(@HostParam("url") String url,
                                                                     @PathParam("secret-name") String secretName,
                                                                     @QueryParam("maxresults") Integer maxresults,
                                                                     @QueryParam("api-version") String apiVersion,
                                                                     @HeaderParam("accept-language") String acceptLanguage,
                                                                     @HeaderParam("Content-Type") String type,
                                                                     Context context);

        @Get("secrets/{secret-name}/versions")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        @ReturnValueWireType(SecretPropertiesPage.class)
        PagedResponse<SecretProperties> getSecretVersions(@HostParam("url") String url,
                                                          @PathParam("secret-name") String secretName,
                                                          @QueryParam("maxresults") Integer maxresults,
                                                          @QueryParam("api-version") String apiVersion,
                                                          @HeaderParam("accept-language") String acceptLanguage,
                                                          @HeaderParam("Content-Type") String type,
                                                          Context context);

        @Get("{nextUrl}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        @ReturnValueWireType(SecretPropertiesPage.class)
        Mono<PagedResponse<SecretProperties>> getSecretsAsync(@HostParam("url") String url,
                                                              @PathParam(value = "nextUrl", encoded = true) String nextUrl,
                                                              @HeaderParam("accept-language") String acceptLanguage,
                                                              @HeaderParam("Content-Type") String type,
                                                              Context context);

        @Get("{nextUrl}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        @ReturnValueWireType(SecretPropertiesPage.class)
        PagedResponse<SecretProperties> getSecrets(@HostParam("url") String url,
                                                   @PathParam(value = "nextUrl", encoded = true) String nextUrl,
                                                   @HeaderParam("accept-language") String acceptLanguage,
                                                   @HeaderParam("Content-Type") String type,
                                                   Context context);

        @Get("deletedsecrets")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        @ReturnValueWireType(DeletedSecretPage.class)
        Mono<PagedResponse<DeletedSecret>> getDeletedSecretsAsync(@HostParam("url") String url,
                                                                  @QueryParam("maxresults") Integer maxresults,
                                                                  @QueryParam("api-version") String apiVersion,
                                                                  @HeaderParam("accept-language") String acceptLanguage,
                                                                  @HeaderParam("Content-Type") String type,
                                                                  Context context);

        @Get("deletedsecrets")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        @ReturnValueWireType(DeletedSecretPage.class)
        PagedResponse<DeletedSecret> getDeletedSecrets(@HostParam("url") String url,
                                                       @QueryParam("maxresults") Integer maxresults,
                                                       @QueryParam("api-version") String apiVersion,
                                                       @HeaderParam("accept-language") String acceptLanguage,
                                                       @HeaderParam("Content-Type") String type,
                                                       Context context);

        @Get("{nextUrl}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        @ReturnValueWireType(DeletedSecretPage.class)
        Mono<PagedResponse<DeletedSecret>> getDeletedSecretsAsync(@HostParam("url") String url,
                                                                  @PathParam(value = "nextUrl", encoded = true) String nextUrl,
                                                                  @HeaderParam("accept-language") String acceptLanguage,
                                                                  @HeaderParam("Content-Type") String type,
                                                                  Context context);

        @Get("{nextUrl}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        @ReturnValueWireType(DeletedSecretPage.class)
        PagedResponse<DeletedSecret> getDeletedSecrets(@HostParam("url") String url,
                                                       @PathParam(value = "nextUrl", encoded = true) String nextUrl,
                                                       @HeaderParam("accept-language") String acceptLanguage,
                                                       @HeaderParam("Content-Type") String type,
                                                       Context context);
    }

    public Mono<Response<KeyVaultSecret>> setSecretWithResponseAsync(KeyVaultSecret secret, Context context) {
        SecretRequestParameters parameters = validateAndCreateSetSecretParameters(secret);

        return service.setSecretAsync(vaultUrl, secret.getName(), secretServiceVersion.getVersion(), ACCEPT_LANGUAGE,
                parameters, CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY,
                    KEYVAULT_TRACING_NAMESPACE_VALUE))
            .doOnRequest(ignored -> logger.verbose("Setting secret - {}", secret.getName()))
            .doOnSuccess(response -> logger.verbose("Set secret - {}", response.getValue().getName()))
            .doOnError(error -> logger.warning("Failed to set secret - {}", secret.getName(), error));
    }

    public Response<KeyVaultSecret> setSecretWithResponse(KeyVaultSecret secret, Context context) {
        SecretRequestParameters parameters = validateAndCreateSetSecretParameters(secret);
        context = context == null ? Context.NONE : context;
        context = enableSyncRestProxy(context);

        return service.setSecret(vaultUrl, secret.getName(), secretServiceVersion.getVersion(), ACCEPT_LANGUAGE,
            parameters, CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY,
                KEYVAULT_TRACING_NAMESPACE_VALUE));
    }

    private SecretRequestParameters validateAndCreateSetSecretParameters(KeyVaultSecret secret) {
        Objects.requireNonNull(secret, "The Secret input parameter cannot be null.");

        return new SecretRequestParameters()
            .setValue(secret.getValue())
            .setTags(secret.getProperties().getTags())
            .setContentType(secret.getProperties().getContentType())
            .setSecretAttributes(new SecretRequestAttributes(secret.getProperties()));
    }

    public Mono<Response<KeyVaultSecret>> setSecretWithResponseAsync(String name, String value, Context context) {
        SecretRequestParameters parameters = new SecretRequestParameters().setValue(value);

        return service.setSecretAsync(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE, parameters,
                CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
            .doOnRequest(ignored -> logger.verbose("Setting secret - {}", name))
            .doOnSuccess(response -> logger.verbose("Set secret - {}", response.getValue().getName()))
            .doOnError(error -> logger.warning("Failed to set secret - {}", name, error));
    }

    public Response<KeyVaultSecret> setSecretWithResponse(String name, String value, Context context) {
        SecretRequestParameters parameters = new SecretRequestParameters().setValue(value);
        context = context == null ? Context.NONE : context;
        context = enableSyncRestProxy(context);

        return service.setSecret(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE, parameters,
            CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE));
    }

    public Mono<Response<KeyVaultSecret>> getSecretWithResponseAsync(String name, String version, Context context) {
        return service.getSecretAsync(vaultUrl, name, version == null ? "" : version, secretServiceVersion.getVersion(),
                ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY,
                    KEYVAULT_TRACING_NAMESPACE_VALUE))
            .doOnRequest(ignoredValue -> logger.verbose("Retrieving secret - {}", name))
            .doOnSuccess(response -> logger.verbose("Retrieved secret - {}", response.getValue().getName()))
            .doOnError(error -> logger.warning("Failed to get secret - {}", name, error));
    }

    public Response<KeyVaultSecret> getSecretWithResponse(String name, String version, Context context) {
        context = context == null ? Context.NONE : context;
        context = enableSyncRestProxy(context);

        return service.getSecret(vaultUrl, name, version == null ? "" : version, secretServiceVersion.getVersion(),
            ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY,
                KEYVAULT_TRACING_NAMESPACE_VALUE));
    }

    public Mono<Response<SecretProperties>> updateSecretPropertiesWithResponseAsync(SecretProperties secretProperties,
                                                                                    Context context) {
        SecretRequestParameters parameters = validateAndCreateUpdateSecretRequestParameters(secretProperties);

        return service.updateSecretAsync(vaultUrl, secretProperties.getName(), secretProperties.getVersion(),
                secretServiceVersion.getVersion(), ACCEPT_LANGUAGE, parameters, CONTENT_TYPE_HEADER_VALUE,
                context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
            .doOnRequest(ignored -> logger.verbose("Updating secret - {}", secretProperties.getName()))
            .doOnSuccess(response -> logger.verbose("Updated secret - {}", response.getValue().getName()))
            .doOnError(error -> logger.warning("Failed to update secret - {}", secretProperties.getName(), error));
    }

    public Response<SecretProperties> updateSecretPropertiesWithResponse(SecretProperties secretProperties,
                                                                         Context context) {
        SecretRequestParameters parameters = validateAndCreateUpdateSecretRequestParameters(secretProperties);
        context = context == null ? Context.NONE : context;
        context = enableSyncRestProxy(context);

        return service.updateSecret(vaultUrl, secretProperties.getName(), secretProperties.getVersion(),
            secretServiceVersion.getVersion(), ACCEPT_LANGUAGE, parameters, CONTENT_TYPE_HEADER_VALUE,
            context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE));
    }

    private SecretRequestParameters validateAndCreateUpdateSecretRequestParameters(SecretProperties secretProperties) {
        Objects.requireNonNull(secretProperties, "The secret properties input parameter cannot be null.");

        return new SecretRequestParameters()
            .setTags(secretProperties.getTags())
            .setContentType(secretProperties.getContentType())
            .setSecretAttributes(new SecretRequestAttributes(secretProperties));
    }

    public PollerFlux<DeletedSecret, Void> beginDeleteSecretAsync(String name) {
        return new PollerFlux<>(getDefaultPollingInterval(),
            activationOperationAsync(name),
            createPollOperationAsync(name),
            (pollingContext, firstResponse) -> Mono.empty(),
            (pollingContext) -> Mono.empty());
    }

    public SyncPoller<DeletedSecret, Void> beginDeleteSecret(String name, Context context) {
        return SyncPoller.createPoller(getDefaultPollingInterval(),
            cxt -> new PollResponse<>(LongRunningOperationStatus.NOT_STARTED, activationOperation(name, context).apply(cxt)),
            createPollOperation(name, context),
            (pollingContext, firstResponse) -> null,
            (pollingContext) -> null);
    }

    private Function<PollingContext<DeletedSecret>, Mono<DeletedSecret>> activationOperationAsync(String name) {
        return (pollingContext) -> withContext(context -> deleteSecretWithResponseAsync(name, context)).
            flatMap(deletedSecretResponse -> Mono.just(deletedSecretResponse.getValue()));
    }

    private Function<PollingContext<DeletedSecret>, DeletedSecret> activationOperation(String name, Context context) {
        return (pollingContext) -> deleteSecretWithResponse(name, context).getValue();
    }

    /**
     * Polling operation to poll on the delete secret operation status.
     */
    private Function<PollingContext<DeletedSecret>, Mono<PollResponse<DeletedSecret>>> createPollOperationAsync(String keyName) {
        return pollingContext ->
            withContext(context -> service.getDeletedSecretPollerAsync(vaultUrl, keyName,
                secretServiceVersion.getVersion(), ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE,
                context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE)))
                .flatMap(deletedSecretResponse -> {
                    if (deletedSecretResponse.getStatusCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                        return Mono.defer(() ->
                            Mono.just(new PollResponse<>(LongRunningOperationStatus.IN_PROGRESS,
                                pollingContext.getLatestResponse().getValue())));
                    }

                    return Mono.defer(() ->
                        Mono.just(new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                            deletedSecretResponse.getValue())));
                })
                // This means either vault has soft-delete disabled or permission is not granted for the get deleted key
                // operation. In both cases deletion operation was successful when activation operation succeeded before
                // reaching here.
                .onErrorReturn(new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                    pollingContext.getLatestResponse().getValue()));
    }

    /**
     * Polling operation to poll on the delete secret operation status.
     */
    private Function<PollingContext<DeletedSecret>, PollResponse<DeletedSecret>> createPollOperation(String keyName,
                                                                                                     Context context) {

        return pollingContext -> {
            try {
                Context contextToUse = context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE);
                contextToUse = enableSyncRestProxy(contextToUse);
                Response<DeletedSecret> deletedSecretResponse = service.getDeletedSecretPoller(vaultUrl, keyName,
                    secretServiceVersion.getVersion(), ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE, contextToUse);
                if (deletedSecretResponse.getStatusCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                    return new PollResponse<>(LongRunningOperationStatus.IN_PROGRESS,
                        pollingContext.getLatestResponse().getValue());
                }

                return new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                    deletedSecretResponse.getValue());
            } catch (HttpResponseException e) {
                // This means either vault has soft-delete disabled or permission is not granted for the get deleted key
                // operation. In both cases deletion operation was successful when activation operation succeeded before
                // reaching here.
                return new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                    pollingContext.getLatestResponse().getValue());
            }
        };
    }

    private Mono<Response<DeletedSecret>> deleteSecretWithResponseAsync(String name, Context context) {
        return service.deleteSecretAsync(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE,
                CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
            .doOnRequest(ignored -> logger.verbose("Deleting secret - {}", name))
            .doOnSuccess(response -> logger.verbose("Deleted secret - {}", response.getValue().getName()))
            .doOnError(error -> logger.warning("Failed to delete secret - {}", name, error));
    }

    private Response<DeletedSecret> deleteSecretWithResponse(String name, Context context) {
        context = enableSyncRestProxy(context);
        return service.deleteSecret(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE,
                CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE));
    }

    public Mono<Response<DeletedSecret>> getDeletedSecretWithResponseAsync(String name, Context context) {
        return service.getDeletedSecretAsync(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE,
                CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
            .doOnRequest(ignored -> logger.verbose("Retrieving deleted secret - {}", name))
            .doOnSuccess(response -> logger.verbose("Retrieved deleted secret - {}", response.getValue().getName()))
            .doOnError(error -> logger.warning("Failed to retrieve deleted secret - {}", name, error));
    }

    public Response<DeletedSecret> getDeletedSecretWithResponse(String name, Context context) {
        context = context == null ? Context.NONE : context;
        context = enableSyncRestProxy(context);

        return service.getDeletedSecret(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE,
            CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE));
    }

    public Mono<Response<Void>> purgeDeletedSecretWithResponseAsync(String name, Context context) {
        return service.purgeDeletedSecretAsync(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE,
                CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
            .doOnRequest(ignored -> logger.verbose("Purging deleted secret - {}", name))
            .doOnSuccess(response -> logger.verbose("Purged deleted secret - {}", name))
            .doOnError(error -> logger.warning("Failed to purge deleted secret - {}", name, error));
    }

    public Response<Void> purgeDeletedSecretWithResponse(String name, Context context) {
        context = context == null ? Context.NONE : context;
        context = enableSyncRestProxy(context);

        return service.purgeDeletedSecret(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE,
            CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE));
    }

    public PollerFlux<KeyVaultSecret, Void> beginRecoverDeletedSecretAsync(String name) {
        return new PollerFlux<>(getDefaultPollingInterval(),
            recoverActivationOperation(name),
            createRecoverPollOperation(name),
            (pollerContext, firstResponse) -> Mono.empty(),
            (pollingContext) -> Mono.empty());
    }

    private Function<PollingContext<KeyVaultSecret>, Mono<KeyVaultSecret>> recoverActivationOperation(String name) {
        return (pollingContext) -> withContext(context -> recoverDeletedSecretWithResponseAsync(name,
            context)).flatMap(keyResponse -> Mono.just(keyResponse.getValue()));
    }

    /*
     * Polling operation to poll on the recover deleted secret operation status.
     */
    private Function<PollingContext<KeyVaultSecret>, Mono<PollResponse<KeyVaultSecret>>> createRecoverPollOperation(String secretName) {
        return pollingContext ->
            withContext(context ->
                service.getSecretPollerAsync(vaultUrl, secretName, "", secretServiceVersion.getVersion(),
                    ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY,
                        KEYVAULT_TRACING_NAMESPACE_VALUE)))
                .flatMap(secretResponse -> {
                    if (secretResponse.getStatusCode() == 404) {
                        return Mono.defer(() ->
                            Mono.just(new PollResponse<>(LongRunningOperationStatus.IN_PROGRESS,
                                pollingContext.getLatestResponse().getValue())));
                    }

                    return Mono.defer(() ->
                        Mono.just(new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                            secretResponse.getValue())));
                })
                // This means permission is not granted for the get deleted key operation. In both cases the deletion
                // operation was successful when activation operation succeeded before reaching here.
                .onErrorReturn(new PollResponse<>(LongRunningOperationStatus.SUCCESSFULLY_COMPLETED,
                    pollingContext.getLatestResponse().getValue()));
    }

    private Mono<Response<KeyVaultSecret>> recoverDeletedSecretWithResponseAsync(String name, Context context) {
        return service.recoverDeletedSecretAsync(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE,
                CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
            .doOnRequest(ignored -> logger.verbose("Recovering deleted secret - {}", name))
            .doOnSuccess(response -> logger.verbose("Recovered deleted secret - {}", response.getValue().getName()))
            .doOnError(error -> logger.warning("Failed to recover deleted secret - {}", name, error));
    }

    public Mono<Response<byte[]>> backupSecretWithResponseAsync(String name, Context context) {
        return service.backupSecretAsync(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE,
                CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
            .doOnRequest(ignored -> logger.verbose("Backing up secret - {}", name))
            .doOnSuccess(response -> logger.verbose("Backed up secret - {}", name))
            .doOnError(error -> logger.warning("Failed to back up secret - {}", name, error))
            .flatMap(base64URLResponse -> Mono.just(new SimpleResponse<>(base64URLResponse.getRequest(),
                base64URLResponse.getStatusCode(), base64URLResponse.getHeaders(),
                base64URLResponse.getValue().getValue())));
    }

    public Response<byte[]> backupSecretWithResponse(String name, Context context) {
        context = context == null ? Context.NONE : context;
        context = enableSyncRestProxy(context);
        Response<SecretBackup> secretBackupResponse = service.
            backupSecret(vaultUrl, name, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE,
                context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE));

        return new SimpleResponse<>(secretBackupResponse.getRequest(), secretBackupResponse.getStatusCode(),
            secretBackupResponse.getHeaders(), secretBackupResponse.getValue().getValue());
    }

    public Mono<Response<KeyVaultSecret>> restoreSecretBackupWithResponseAsync(byte[] backup, Context context) {
        SecretRestoreRequestParameters parameters = new SecretRestoreRequestParameters().setSecretBackup(backup);

        return service.restoreSecretAsync(vaultUrl, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE, parameters,
                CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
            .doOnRequest(ignored -> logger.verbose("Attempting to restore secret"))
            .doOnSuccess(response -> logger.verbose("Restored secret - {}", response.getValue().getName()))
            .doOnError(error -> logger.warning("Failed to restore secret", error));
    }

    public Response<KeyVaultSecret> restoreSecretBackupWithResponse(byte[] backup, Context context) {
        SecretRestoreRequestParameters parameters = new SecretRestoreRequestParameters().setSecretBackup(backup);
        context = context == null ? Context.NONE : context;
        context = enableSyncRestProxy(context);

        return service.restoreSecret(vaultUrl, secretServiceVersion.getVersion(), ACCEPT_LANGUAGE, parameters,
            CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE));
    }

    public PagedFlux<SecretProperties> listPropertiesOfSecrets() {
        try {
            return new PagedFlux<>(
                () -> withContext(this::listSecretsFirstPage),
                continuationToken -> withContext(context -> listSecretsNextPage(continuationToken, context)));
        } catch (RuntimeException ex) {
            return new PagedFlux<>(() -> monoError(logger, ex));
        }
    }

    public PagedFlux<SecretProperties> listPropertiesOfSecrets(Context context) {
        return new PagedFlux<>(
            () -> listSecretsFirstPage(context),
            continuationToken -> listSecretsNextPage(continuationToken, context));
    }

    /**
     * Gets attributes of the first 25 secrets that can be found on a given key vault.
     *
     * @param context Additional {@link Context} that is passed through the {@link HttpPipeline} during the service
     * call.
     *
     * @return A {@link Mono} of {@link PagedResponse} containing {@link SecretProperties} instances from the next page
     * of results.
     */
    private Mono<PagedResponse<SecretProperties>> listSecretsFirstPage(Context context) {
        try {
            return service.getSecretsAsync(vaultUrl, DEFAULT_MAX_PAGE_RESULTS, secretServiceVersion.getVersion(),
                    ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY,
                        KEYVAULT_TRACING_NAMESPACE_VALUE))
                .doOnRequest(ignored -> logger.verbose("Listing secrets"))
                .doOnSuccess(response -> logger.verbose("Listed secrets"))
                .doOnError(error -> logger.warning("Failed to list secrets", error));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Gets attributes of all the keys given by the {@code nextPageLink} that was retrieved from a call to
     * {@link SecretClientImpl#listPropertiesOfSecrets()}.
     *
     * @param continuationToken The {@link PagedResponse#getContinuationToken()} from a previous, successful call to one
     * of the list operations.
     *
     * @return A {@link Mono} of {@link PagedResponse} containing {@link SecretProperties} instances from the next page
     * of results.
     */
    private Mono<PagedResponse<SecretProperties>> listSecretsNextPage(String continuationToken, Context context) {
        try {
            return service.getSecretsAsync(vaultUrl, continuationToken, ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE,
                    context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
                .doOnRequest(ignoredValue ->
                    logger.verbose("Retrieving the next secrets page - Page {}", continuationToken))
                .doOnSuccess(response -> logger.verbose("Retrieved the next secrets page - Page {}", continuationToken))
                .doOnError(error ->
                    logger.warning("Failed to retrieve the next secrets page - Page {}", continuationToken, error));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    public PagedFlux<DeletedSecret> listDeletedSecrets() {
        try {
            return new PagedFlux<>(
                () -> withContext(this::listDeletedSecretsFirstPage),
                continuationToken -> withContext(context -> listDeletedSecretsNextPage(continuationToken, context)));
        } catch (RuntimeException ex) {
            return new PagedFlux<>(() -> monoError(logger, ex));
        }
    }

    public PagedFlux<DeletedSecret> listDeletedSecrets(Context context) {
        return new PagedFlux<>(
            () -> listDeletedSecretsFirstPage(context),
            continuationToken -> listDeletedSecretsNextPage(continuationToken, context));
    }

    /**
     * Gets attributes of the first 25 deleted secrets that can be found on a given key vault.
     *
     * @param context Additional {@link Context} that is passed through the {@link HttpPipeline} during the service
     * call.
     *
     * @return A {@link Mono} of {@link PagedResponse} containing {@link SecretProperties} instances from the next page
     * of results.
     */
    private Mono<PagedResponse<DeletedSecret>> listDeletedSecretsFirstPage(Context context) {
        try {
            return service.getDeletedSecretsAsync(vaultUrl, DEFAULT_MAX_PAGE_RESULTS, secretServiceVersion.getVersion(),
                    ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY,
                        KEYVAULT_TRACING_NAMESPACE_VALUE))
                .doOnRequest(ignored -> logger.verbose("Listing deleted secrets"))
                .doOnSuccess(response -> logger.verbose("Listed deleted secrets"))
                .doOnError(error -> logger.warning("Failed to list deleted secrets", error));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Gets attributes of all the secrets given by the {@code nextPageLink} that was retrieved from a call to
     * {@link SecretClientImpl#listDeletedSecrets()}.
     *
     * @param continuationToken The {@link Page#getContinuationToken()} from a previous, successful call to one of the
     * list operations.
     *
     * @return A {@link Mono} of {@link PagedResponse} that contains {@link DeletedSecret} from the next page of
     * results.
     */
    private Mono<PagedResponse<DeletedSecret>> listDeletedSecretsNextPage(String continuationToken, Context context) {
        try {
            return service.getDeletedSecretsAsync(vaultUrl, continuationToken, ACCEPT_LANGUAGE,
                    CONTENT_TYPE_HEADER_VALUE, context.addData(AZ_TRACING_NAMESPACE_KEY,
                        KEYVAULT_TRACING_NAMESPACE_VALUE))
                .doOnRequest(ignoredValue ->
                    logger.verbose("Retrieving the next deleted secrets page - Page {}", continuationToken))
                .doOnSuccess(response ->
                    logger.verbose("Retrieved the next deleted secrets page - Page {}", continuationToken))
                .doOnError(error ->
                    logger.warning("Failed to retrieve the next deleted secrets page - Page {}", continuationToken,
                        error));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    public PagedFlux<SecretProperties> listPropertiesOfSecretVersions(String name) {
        try {
            return new PagedFlux<>(
                () -> withContext(context -> listSecretVersionsFirstPage(name, context)),
                continuationToken -> withContext(context -> listSecretVersionsNextPage(continuationToken, context)));
        } catch (RuntimeException ex) {
            return new PagedFlux<>(() -> monoError(logger, ex));
        }
    }

    public PagedFlux<SecretProperties> listPropertiesOfSecretVersions(String name, Context context) {
        return new PagedFlux<>(
            () -> listSecretVersionsFirstPage(name, context),
            continuationToken -> listSecretVersionsNextPage(continuationToken, context));
    }

    /**
     * Gets attributes of the first 25 versions of a secret.
     *
     * @param context Additional {@link Context} that is passed through the {@link HttpPipeline} during the service
     * call.
     *
     * @return A {@link Mono} of {@link PagedResponse} containing {@link SecretProperties} instances from the next page
     * of results.
     */
    private Mono<PagedResponse<SecretProperties>> listSecretVersionsFirstPage(String name, Context context) {
        try {
            return service.getSecretVersionsAsync(vaultUrl, name, DEFAULT_MAX_PAGE_RESULTS,
                    secretServiceVersion.getVersion(), ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE,
                    context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
                .doOnRequest(ignored -> logger.verbose("Listing secret versions - {}", name))
                .doOnSuccess(response -> logger.verbose("Listed secret versions - {}", name))
                .doOnError(error -> logger.warning("Failed to list secret versions - {}", name, error));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Gets attributes of versions of a key given by the {@code nextPageLink} that was retrieved from a call to
     * {@link SecretClientImpl#listPropertiesOfSecretVersions(String)}.
     *
     * @param continuationToken The {@link PagedResponse#getContinuationToken()} from a previous, successful call to one
     * of the list operations.
     *
     * @return A {@link Mono} of {@link PagedResponse} containing {@link SecretProperties} instances from the next page
     * of results.
     */
    private Mono<PagedResponse<SecretProperties>> listSecretVersionsNextPage(String continuationToken, Context context) {
        try {
            return service.getSecretsAsync(vaultUrl, continuationToken, ACCEPT_LANGUAGE, CONTENT_TYPE_HEADER_VALUE,
                    context.addData(AZ_TRACING_NAMESPACE_KEY, KEYVAULT_TRACING_NAMESPACE_VALUE))
                .doOnRequest(ignoredValue ->
                    logger.verbose("Retrieving the next secrets versions page - Page {}", continuationToken))
                .doOnSuccess(response ->
                    logger.verbose("Retrieved the next secrets versions page - Page {}", continuationToken))
                .doOnError(error ->
                    logger.warning("Failed to retrieve the next secrets versions page - Page {}", continuationToken,
                        error));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    private Context enableSyncRestProxy(Context context) {
        return context.addData(HTTP_REST_PROXY_SYNC_PROXY_ENABLE, true);
    }
}
