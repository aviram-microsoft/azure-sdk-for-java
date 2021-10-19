// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.videoanalyzer.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.videoanalyzer.fluent.PipelineJobsClient;
import com.azure.resourcemanager.videoanalyzer.fluent.models.PipelineJobInner;
import com.azure.resourcemanager.videoanalyzer.models.PipelineJob;
import com.azure.resourcemanager.videoanalyzer.models.PipelineJobs;
import com.fasterxml.jackson.annotation.JsonIgnore;

public final class PipelineJobsImpl implements PipelineJobs {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(PipelineJobsImpl.class);

    private final PipelineJobsClient innerClient;

    private final com.azure.resourcemanager.videoanalyzer.VideoAnalyzerManager serviceManager;

    public PipelineJobsImpl(
        PipelineJobsClient innerClient, com.azure.resourcemanager.videoanalyzer.VideoAnalyzerManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<PipelineJob> list(String resourceGroupName, String accountName) {
        PagedIterable<PipelineJobInner> inner = this.serviceClient().list(resourceGroupName, accountName);
        return Utils.mapPage(inner, inner1 -> new PipelineJobImpl(inner1, this.manager()));
    }

    public PagedIterable<PipelineJob> list(
        String resourceGroupName, String accountName, String filter, Integer top, Context context) {
        PagedIterable<PipelineJobInner> inner =
            this.serviceClient().list(resourceGroupName, accountName, filter, top, context);
        return Utils.mapPage(inner, inner1 -> new PipelineJobImpl(inner1, this.manager()));
    }

    public PipelineJob get(String resourceGroupName, String accountName, String pipelineJobName) {
        PipelineJobInner inner = this.serviceClient().get(resourceGroupName, accountName, pipelineJobName);
        if (inner != null) {
            return new PipelineJobImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<PipelineJob> getWithResponse(
        String resourceGroupName, String accountName, String pipelineJobName, Context context) {
        Response<PipelineJobInner> inner =
            this.serviceClient().getWithResponse(resourceGroupName, accountName, pipelineJobName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new PipelineJobImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public void delete(String resourceGroupName, String accountName, String pipelineJobName) {
        this.serviceClient().delete(resourceGroupName, accountName, pipelineJobName);
    }

    public Response<Void> deleteWithResponse(
        String resourceGroupName, String accountName, String pipelineJobName, Context context) {
        return this.serviceClient().deleteWithResponse(resourceGroupName, accountName, pipelineJobName, context);
    }

    public void cancel(String resourceGroupName, String accountName, String pipelineJobName) {
        this.serviceClient().cancel(resourceGroupName, accountName, pipelineJobName);
    }

    public void cancel(String resourceGroupName, String accountName, String pipelineJobName, Context context) {
        this.serviceClient().cancel(resourceGroupName, accountName, pipelineJobName, context);
    }

    public PipelineJob getById(String id) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String accountName = Utils.getValueFromIdByName(id, "videoAnalyzers");
        if (accountName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'videoAnalyzers'.", id)));
        }
        String pipelineJobName = Utils.getValueFromIdByName(id, "pipelineJobs");
        if (pipelineJobName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'pipelineJobs'.", id)));
        }
        return this.getWithResponse(resourceGroupName, accountName, pipelineJobName, Context.NONE).getValue();
    }

    public Response<PipelineJob> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String accountName = Utils.getValueFromIdByName(id, "videoAnalyzers");
        if (accountName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'videoAnalyzers'.", id)));
        }
        String pipelineJobName = Utils.getValueFromIdByName(id, "pipelineJobs");
        if (pipelineJobName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'pipelineJobs'.", id)));
        }
        return this.getWithResponse(resourceGroupName, accountName, pipelineJobName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String accountName = Utils.getValueFromIdByName(id, "videoAnalyzers");
        if (accountName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'videoAnalyzers'.", id)));
        }
        String pipelineJobName = Utils.getValueFromIdByName(id, "pipelineJobs");
        if (pipelineJobName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'pipelineJobs'.", id)));
        }
        this.deleteWithResponse(resourceGroupName, accountName, pipelineJobName, Context.NONE).getValue();
    }

    public Response<Void> deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = Utils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String accountName = Utils.getValueFromIdByName(id, "videoAnalyzers");
        if (accountName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String
                            .format("The resource ID '%s' is not valid. Missing path segment 'videoAnalyzers'.", id)));
        }
        String pipelineJobName = Utils.getValueFromIdByName(id, "pipelineJobs");
        if (pipelineJobName == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        String.format("The resource ID '%s' is not valid. Missing path segment 'pipelineJobs'.", id)));
        }
        return this.deleteWithResponse(resourceGroupName, accountName, pipelineJobName, context);
    }

    private PipelineJobsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.videoanalyzer.VideoAnalyzerManager manager() {
        return this.serviceManager;
    }

    public PipelineJobImpl define(String name) {
        return new PipelineJobImpl(name, this.manager());
    }
}