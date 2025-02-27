// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.machinelearning.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.machinelearning.fluent.models.PrivateLinkResourceProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class PrivateLinkResourcePropertiesTests {
    @Test
    public void testDeserialize() {
        PrivateLinkResourceProperties model =
            BinaryData
                .fromString(
                    "{\"groupId\":\"ifthnz\",\"requiredMembers\":[\"sl\",\"nayqi\",\"ynduha\",\"hqlkthumaqo\"],\"requiredZoneNames\":[\"ycduier\",\"gccymvaolpssl\"]}")
                .toObject(PrivateLinkResourceProperties.class);
        Assertions.assertEquals("ycduier", model.requiredZoneNames().get(0));
    }

    @Test
    public void testSerialize() {
        PrivateLinkResourceProperties model =
            new PrivateLinkResourceProperties().withRequiredZoneNames(Arrays.asList("ycduier", "gccymvaolpssl"));
        model = BinaryData.fromObject(model).toObject(PrivateLinkResourceProperties.class);
        Assertions.assertEquals("ycduier", model.requiredZoneNames().get(0));
    }
}
