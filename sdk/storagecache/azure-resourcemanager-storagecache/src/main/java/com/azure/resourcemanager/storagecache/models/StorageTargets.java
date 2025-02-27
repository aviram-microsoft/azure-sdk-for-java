// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/** Resource collection API of StorageTargets. */
public interface StorageTargets {
    /**
     * Tells a storage target to refresh its DNS information.
     *
     * @param resourceGroupName Target resource group.
     * @param cacheName Name of Cache. Length of name must not be greater than 80 and chars must be from the
     *     [-0-9a-zA-Z_] char class.
     * @param storageTargetName Name of Storage Target.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void dnsRefresh(String resourceGroupName, String cacheName, String storageTargetName);

    /**
     * Tells a storage target to refresh its DNS information.
     *
     * @param resourceGroupName Target resource group.
     * @param cacheName Name of Cache. Length of name must not be greater than 80 and chars must be from the
     *     [-0-9a-zA-Z_] char class.
     * @param storageTargetName Name of Storage Target.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void dnsRefresh(String resourceGroupName, String cacheName, String storageTargetName, Context context);

    /**
     * Returns a list of Storage Targets for the specified Cache.
     *
     * @param resourceGroupName Target resource group.
     * @param cacheName Name of Cache. Length of name must not be greater than 80 and chars must be from the
     *     [-0-9a-zA-Z_] char class.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Storage Targets as paginated response with {@link PagedIterable}.
     */
    PagedIterable<StorageTarget> listByCache(String resourceGroupName, String cacheName);

    /**
     * Returns a list of Storage Targets for the specified Cache.
     *
     * @param resourceGroupName Target resource group.
     * @param cacheName Name of Cache. Length of name must not be greater than 80 and chars must be from the
     *     [-0-9a-zA-Z_] char class.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of Storage Targets as paginated response with {@link PagedIterable}.
     */
    PagedIterable<StorageTarget> listByCache(String resourceGroupName, String cacheName, Context context);

    /**
     * Removes a Storage Target from a Cache. This operation is allowed at any time, but if the Cache is down or
     * unhealthy, the actual removal of the Storage Target may be delayed until the Cache is healthy again. Note that if
     * the Cache has data to flush to the Storage Target, the data will be flushed before the Storage Target will be
     * deleted.
     *
     * @param resourceGroupName Target resource group.
     * @param cacheName Name of Cache. Length of name must not be greater than 80 and chars must be from the
     *     [-0-9a-zA-Z_] char class.
     * @param storageTargetName Name of Storage Target.
     * @param force Boolean value requesting the force delete operation for a storage target. Force delete discards
     *     unwritten-data in the cache instead of flushing it to back-end storage.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String cacheName, String storageTargetName, String force);

    /**
     * Removes a Storage Target from a Cache. This operation is allowed at any time, but if the Cache is down or
     * unhealthy, the actual removal of the Storage Target may be delayed until the Cache is healthy again. Note that if
     * the Cache has data to flush to the Storage Target, the data will be flushed before the Storage Target will be
     * deleted.
     *
     * @param resourceGroupName Target resource group.
     * @param cacheName Name of Cache. Length of name must not be greater than 80 and chars must be from the
     *     [-0-9a-zA-Z_] char class.
     * @param storageTargetName Name of Storage Target.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String cacheName, String storageTargetName);

    /**
     * Removes a Storage Target from a Cache. This operation is allowed at any time, but if the Cache is down or
     * unhealthy, the actual removal of the Storage Target may be delayed until the Cache is healthy again. Note that if
     * the Cache has data to flush to the Storage Target, the data will be flushed before the Storage Target will be
     * deleted.
     *
     * @param resourceGroupName Target resource group.
     * @param cacheName Name of Cache. Length of name must not be greater than 80 and chars must be from the
     *     [-0-9a-zA-Z_] char class.
     * @param storageTargetName Name of Storage Target.
     * @param force Boolean value requesting the force delete operation for a storage target. Force delete discards
     *     unwritten-data in the cache instead of flushing it to back-end storage.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String cacheName, String storageTargetName, String force, Context context);

    /**
     * Returns a Storage Target from a Cache.
     *
     * @param resourceGroupName Target resource group.
     * @param cacheName Name of Cache. Length of name must not be greater than 80 and chars must be from the
     *     [-0-9a-zA-Z_] char class.
     * @param storageTargetName Name of Storage Target.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return type of the Storage Target.
     */
    StorageTarget get(String resourceGroupName, String cacheName, String storageTargetName);

    /**
     * Returns a Storage Target from a Cache.
     *
     * @param resourceGroupName Target resource group.
     * @param cacheName Name of Cache. Length of name must not be greater than 80 and chars must be from the
     *     [-0-9a-zA-Z_] char class.
     * @param storageTargetName Name of Storage Target.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return type of the Storage Target along with {@link Response}.
     */
    Response<StorageTarget> getWithResponse(
        String resourceGroupName, String cacheName, String storageTargetName, Context context);

    /**
     * Returns a Storage Target from a Cache.
     *
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return type of the Storage Target along with {@link Response}.
     */
    StorageTarget getById(String id);

    /**
     * Returns a Storage Target from a Cache.
     *
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return type of the Storage Target along with {@link Response}.
     */
    Response<StorageTarget> getByIdWithResponse(String id, Context context);

    /**
     * Removes a Storage Target from a Cache. This operation is allowed at any time, but if the Cache is down or
     * unhealthy, the actual removal of the Storage Target may be delayed until the Cache is healthy again. Note that if
     * the Cache has data to flush to the Storage Target, the data will be flushed before the Storage Target will be
     * deleted.
     *
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Removes a Storage Target from a Cache. This operation is allowed at any time, but if the Cache is down or
     * unhealthy, the actual removal of the Storage Target may be delayed until the Cache is healthy again. Note that if
     * the Cache has data to flush to the Storage Target, the data will be flushed before the Storage Target will be
     * deleted.
     *
     * @param id the resource ID.
     * @param force Boolean value requesting the force delete operation for a storage target. Force delete discards
     *     unwritten-data in the cache instead of flushing it to back-end storage.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByIdWithResponse(String id, String force, Context context);

    /**
     * Begins definition for a new StorageTarget resource.
     *
     * @param name resource name.
     * @return the first stage of the new StorageTarget definition.
     */
    StorageTarget.DefinitionStages.Blank define(String name);
}
