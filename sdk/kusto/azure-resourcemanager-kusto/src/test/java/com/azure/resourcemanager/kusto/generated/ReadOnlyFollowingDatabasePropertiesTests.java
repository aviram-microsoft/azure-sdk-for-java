// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kusto.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.kusto.fluent.models.ReadOnlyFollowingDatabaseProperties;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class ReadOnlyFollowingDatabasePropertiesTests {
    @Test
    public void testDeserialize() {
        ReadOnlyFollowingDatabaseProperties model =
            BinaryData
                .fromString(
                    "{\"provisioningState\":\"Deleting\",\"softDeletePeriod\":\"PT129H4M54S\",\"hotCachePeriod\":\"PT145H15M47S\",\"statistics\":{\"size\":54.328762},\"leaderClusterResourceId\":\"itqscywuggwoluhc\",\"attachedDatabaseConfigurationName\":\"wem\",\"principalsModificationKind\":\"Replace\",\"tableLevelSharingProperties\":{\"tablesToInclude\":[\"rgzdwmsweyp\"],\"tablesToExclude\":[\"xggicccnxqhuexmk\",\"tlstvlzywem\",\"zrncsdt\",\"lusiy\"],\"externalTablesToInclude\":[\"fgytguslfeadcyg\",\"ukyhejhzis\",\"gfpelolppvksrpqv\",\"jzraehtwdwrf\"],\"externalTablesToExclude\":[\"iby\"],\"materializedViewsToInclude\":[\"l\"],\"materializedViewsToExclude\":[\"hfwpracstwit\",\"khevxccedc\",\"nmdyodnwzxl\",\"jc\"]},\"originalDatabaseName\":\"hlt\",\"databaseShareOrigin\":\"Other\"}")
                .toObject(ReadOnlyFollowingDatabaseProperties.class);
        Assertions.assertEquals(Duration.parse("PT145H15M47S"), model.hotCachePeriod());
    }

    @Test
    public void testSerialize() {
        ReadOnlyFollowingDatabaseProperties model =
            new ReadOnlyFollowingDatabaseProperties().withHotCachePeriod(Duration.parse("PT145H15M47S"));
        model = BinaryData.fromObject(model).toObject(ReadOnlyFollowingDatabaseProperties.class);
        Assertions.assertEquals(Duration.parse("PT145H15M47S"), model.hotCachePeriod());
    }
}
