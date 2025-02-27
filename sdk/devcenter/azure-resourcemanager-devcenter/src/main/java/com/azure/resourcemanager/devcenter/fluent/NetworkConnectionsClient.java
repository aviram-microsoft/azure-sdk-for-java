// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.devcenter.fluent.models.HealthCheckStatusDetailsInner;
import com.azure.resourcemanager.devcenter.fluent.models.NetworkConnectionInner;
import com.azure.resourcemanager.devcenter.models.NetworkConnectionUpdate;

/** An instance of this class provides access to all the operations defined in NetworkConnectionsClient. */
public interface NetworkConnectionsClient {
    /**
     * Lists network connections in a subscription.
     *
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the network connection list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NetworkConnectionInner> list();

    /**
     * Lists network connections in a subscription.
     *
     * @param top The maximum number of resources to return from the operation. Example: '$top=10'.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the network connection list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NetworkConnectionInner> list(Integer top, Context context);

    /**
     * Lists network connections in a resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the network connection list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NetworkConnectionInner> listByResourceGroup(String resourceGroupName);

    /**
     * Lists network connections in a resource group.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param top The maximum number of resources to return from the operation. Example: '$top=10'.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the network connection list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<NetworkConnectionInner> listByResourceGroup(String resourceGroupName, Integer top, Context context);

    /**
     * Gets a network connection resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a network connection resource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<NetworkConnectionInner> getByResourceGroupWithResponse(
        String resourceGroupName, String networkConnectionName, Context context);

    /**
     * Gets a network connection resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a network connection resource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkConnectionInner getByResourceGroup(String resourceGroupName, String networkConnectionName);

    /**
     * Creates or updates a Network Connections resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param body Represents network connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of network related settings.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<NetworkConnectionInner>, NetworkConnectionInner> beginCreateOrUpdate(
        String resourceGroupName, String networkConnectionName, NetworkConnectionInner body);

    /**
     * Creates or updates a Network Connections resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param body Represents network connection.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of network related settings.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<NetworkConnectionInner>, NetworkConnectionInner> beginCreateOrUpdate(
        String resourceGroupName, String networkConnectionName, NetworkConnectionInner body, Context context);

    /**
     * Creates or updates a Network Connections resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param body Represents network connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return network related settings.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkConnectionInner createOrUpdate(
        String resourceGroupName, String networkConnectionName, NetworkConnectionInner body);

    /**
     * Creates or updates a Network Connections resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param body Represents network connection.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return network related settings.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkConnectionInner createOrUpdate(
        String resourceGroupName, String networkConnectionName, NetworkConnectionInner body, Context context);

    /**
     * Partially updates a Network Connection.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param body Represents network connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of network related settings.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<NetworkConnectionInner>, NetworkConnectionInner> beginUpdate(
        String resourceGroupName, String networkConnectionName, NetworkConnectionUpdate body);

    /**
     * Partially updates a Network Connection.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param body Represents network connection.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of network related settings.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<NetworkConnectionInner>, NetworkConnectionInner> beginUpdate(
        String resourceGroupName, String networkConnectionName, NetworkConnectionUpdate body, Context context);

    /**
     * Partially updates a Network Connection.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param body Represents network connection.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return network related settings.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkConnectionInner update(String resourceGroupName, String networkConnectionName, NetworkConnectionUpdate body);

    /**
     * Partially updates a Network Connection.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param body Represents network connection.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return network related settings.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    NetworkConnectionInner update(
        String resourceGroupName, String networkConnectionName, NetworkConnectionUpdate body, Context context);

    /**
     * Deletes a Network Connections resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String networkConnectionName);

    /**
     * Deletes a Network Connections resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(
        String resourceGroupName, String networkConnectionName, Context context);

    /**
     * Deletes a Network Connections resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String networkConnectionName);

    /**
     * Deletes a Network Connections resource.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String networkConnectionName, Context context);

    /**
     * Lists health check status details.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the network health check list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<HealthCheckStatusDetailsInner> listHealthDetails(
        String resourceGroupName, String networkConnectionName);

    /**
     * Lists health check status details.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param top The maximum number of resources to return from the operation. Example: '$top=10'.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of the network health check list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<HealthCheckStatusDetailsInner> listHealthDetails(
        String resourceGroupName, String networkConnectionName, Integer top, Context context);

    /**
     * Gets health check status details.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return health check status details along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<HealthCheckStatusDetailsInner> getHealthDetailsWithResponse(
        String resourceGroupName, String networkConnectionName, Context context);

    /**
     * Gets health check status details.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return health check status details.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    HealthCheckStatusDetailsInner getHealthDetails(String resourceGroupName, String networkConnectionName);

    /**
     * Triggers a new health check run. The execution and health check result can be tracked via the network Connection
     * health check details.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginRunHealthChecks(String resourceGroupName, String networkConnectionName);

    /**
     * Triggers a new health check run. The execution and health check result can be tracked via the network Connection
     * health check details.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginRunHealthChecks(
        String resourceGroupName, String networkConnectionName, Context context);

    /**
     * Triggers a new health check run. The execution and health check result can be tracked via the network Connection
     * health check details.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void runHealthChecks(String resourceGroupName, String networkConnectionName);

    /**
     * Triggers a new health check run. The execution and health check result can be tracked via the network Connection
     * health check details.
     *
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param networkConnectionName Name of the Network Connection that can be applied to a Pool.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void runHealthChecks(String resourceGroupName, String networkConnectionName, Context context);
}
