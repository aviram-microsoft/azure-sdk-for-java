// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.generated;

import com.azure.core.util.Context;

/** Samples for Queue Get. */
public final class QueueGetSamples {
    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2021-04-01/examples/QueueOperationGet.json
     */
    /**
     * Sample code: QueueOperationGet.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void queueOperationGet(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .storageAccounts()
            .manager()
            .serviceClient()
            .getQueues()
            .getWithResponse("res3376", "sto328", "queue6185", Context.NONE);
    }
}