// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.sql.generated;

import com.azure.core.util.Context;

/** Samples for BackupShortTermRetentionPolicies ListByDatabase. */
public final class BackupShortTermRetentionPoliciesListByDatabaseSamples {
    /*
     * x-ms-original-file: specification/sql/resource-manager/Microsoft.Sql/preview/2017-10-01-preview/examples/ListShortTermRetentionPoliciesByDatabase.json
     */
    /**
     * Sample code: Get the short term retention policy for the database.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getTheShortTermRetentionPolicyForTheDatabase(
        com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .sqlServers()
            .manager()
            .serviceClient()
            .getBackupShortTermRetentionPolicies()
            .listByDatabase("Default-SQL-SouthEastAsia", "testsvr", "testdb", Context.NONE);
    }
}
