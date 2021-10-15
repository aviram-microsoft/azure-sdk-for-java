// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logz.generated;

import com.azure.core.util.Context;

/** Samples for SubAccountTagRules List. */
public final class SubAccountTagRulesListSamples {
    /*
     * x-ms-original-file: specification/logz/resource-manager/Microsoft.Logz/stable/2020-10-01/examples/SubAccountTagRules_List.json
     */
    /**
     * Sample code: SubAccountTagRules_List.
     *
     * @param manager Entry point to LogzManager.
     */
    public static void subAccountTagRulesList(com.azure.resourcemanager.logz.LogzManager manager) {
        manager.subAccountTagRules().list("myResourceGroup", "myMonitor", "SubAccount1", Context.NONE);
    }
}