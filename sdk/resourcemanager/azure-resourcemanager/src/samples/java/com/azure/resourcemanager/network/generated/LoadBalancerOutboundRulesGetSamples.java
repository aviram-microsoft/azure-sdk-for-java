// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

import com.azure.core.util.Context;

/** Samples for LoadBalancerOutboundRules Get. */
public final class LoadBalancerOutboundRulesGetSamples {
    /*
     * x-ms-original-file: specification/network/resource-manager/Microsoft.Network/stable/2021-05-01/examples/LoadBalancerOutboundRuleGet.json
     */
    /**
     * Sample code: LoadBalancerOutboundRuleGet.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void loadBalancerOutboundRuleGet(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .networks()
            .manager()
            .serviceClient()
            .getLoadBalancerOutboundRules()
            .getWithResponse("testrg", "lb1", "rule1", Context.NONE);
    }
}