// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesbackup.fluent.models.ResourceGuardProxyBaseResourceInner;
import com.azure.resourcemanager.recoveryservicesbackup.models.ResourceGuardOperationDetail;
import com.azure.resourcemanager.recoveryservicesbackup.models.ResourceGuardProxyBase;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class ResourceGuardProxyBaseResourceInnerTests {
    @Test
    public void testDeserialize() {
        ResourceGuardProxyBaseResourceInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"resourceGuardResourceId\":\"ozphvwauyqncygu\",\"resourceGuardOperationDetails\":[{\"vaultCriticalOperation\":\"p\",\"defaultResourceRequest\":\"scw\"},{\"vaultCriticalOperation\":\"upev\",\"defaultResourceRequest\":\"f\"},{\"vaultCriticalOperation\":\"otxhojujby\",\"defaultResourceRequest\":\"lmcuvhixb\"},{\"vaultCriticalOperation\":\"yfwnylr\",\"defaultResourceRequest\":\"o\"}],\"lastUpdatedTime\":\"ttpkiwkkbnujrywv\",\"description\":\"lbfpncurd\"},\"eTag\":\"wiithtywub\",\"location\":\"cbihwqk\",\"tags\":{\"dgoihxumwctondzj\":\"ntwjch\",\"fdlwg\":\"uu\",\"gseinq\":\"ytsbwtovv\"},\"id\":\"iufxqknpir\",\"name\":\"nepttwqmsni\",\"type\":\"fcdmqnrojlpijn\"}")
                .toObject(ResourceGuardProxyBaseResourceInner.class);
        Assertions.assertEquals("cbihwqk", model.location());
        Assertions.assertEquals("ntwjch", model.tags().get("dgoihxumwctondzj"));
        Assertions.assertEquals("ozphvwauyqncygu", model.properties().resourceGuardResourceId());
        Assertions
            .assertEquals("p", model.properties().resourceGuardOperationDetails().get(0).vaultCriticalOperation());
        Assertions
            .assertEquals("scw", model.properties().resourceGuardOperationDetails().get(0).defaultResourceRequest());
        Assertions.assertEquals("ttpkiwkkbnujrywv", model.properties().lastUpdatedTime());
        Assertions.assertEquals("lbfpncurd", model.properties().description());
        Assertions.assertEquals("wiithtywub", model.etag());
    }

    @Test
    public void testSerialize() {
        ResourceGuardProxyBaseResourceInner model =
            new ResourceGuardProxyBaseResourceInner()
                .withLocation("cbihwqk")
                .withTags(mapOf("dgoihxumwctondzj", "ntwjch", "fdlwg", "uu", "gseinq", "ytsbwtovv"))
                .withProperties(
                    new ResourceGuardProxyBase()
                        .withResourceGuardResourceId("ozphvwauyqncygu")
                        .withResourceGuardOperationDetails(
                            Arrays
                                .asList(
                                    new ResourceGuardOperationDetail()
                                        .withVaultCriticalOperation("p")
                                        .withDefaultResourceRequest("scw"),
                                    new ResourceGuardOperationDetail()
                                        .withVaultCriticalOperation("upev")
                                        .withDefaultResourceRequest("f"),
                                    new ResourceGuardOperationDetail()
                                        .withVaultCriticalOperation("otxhojujby")
                                        .withDefaultResourceRequest("lmcuvhixb"),
                                    new ResourceGuardOperationDetail()
                                        .withVaultCriticalOperation("yfwnylr")
                                        .withDefaultResourceRequest("o")))
                        .withLastUpdatedTime("ttpkiwkkbnujrywv")
                        .withDescription("lbfpncurd"))
                .withEtag("wiithtywub");
        model = BinaryData.fromObject(model).toObject(ResourceGuardProxyBaseResourceInner.class);
        Assertions.assertEquals("cbihwqk", model.location());
        Assertions.assertEquals("ntwjch", model.tags().get("dgoihxumwctondzj"));
        Assertions.assertEquals("ozphvwauyqncygu", model.properties().resourceGuardResourceId());
        Assertions
            .assertEquals("p", model.properties().resourceGuardOperationDetails().get(0).vaultCriticalOperation());
        Assertions
            .assertEquals("scw", model.properties().resourceGuardOperationDetails().get(0).defaultResourceRequest());
        Assertions.assertEquals("ttpkiwkkbnujrywv", model.properties().lastUpdatedTime());
        Assertions.assertEquals("lbfpncurd", model.properties().description());
        Assertions.assertEquals("wiithtywub", model.etag());
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
