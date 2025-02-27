// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dashboard.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.dashboard.models.AzureMonitorWorkspaceIntegration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class AzureMonitorWorkspaceIntegrationTests {
    @Test
    public void testDeserialize() {
        AzureMonitorWorkspaceIntegration model =
            BinaryData
                .fromString("{\"azureMonitorWorkspaceResourceId\":\"yc\"}")
                .toObject(AzureMonitorWorkspaceIntegration.class);
        Assertions.assertEquals("yc", model.azureMonitorWorkspaceResourceId());
    }

    @Test
    public void testSerialize() {
        AzureMonitorWorkspaceIntegration model =
            new AzureMonitorWorkspaceIntegration().withAzureMonitorWorkspaceResourceId("yc");
        model = BinaryData.fromObject(model).toObject(AzureMonitorWorkspaceIntegration.class);
        Assertions.assertEquals("yc", model.azureMonitorWorkspaceResourceId());
    }
}
