// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesbackup.fluent.models.RecoveryPointResourceInner;
import com.azure.resourcemanager.recoveryservicesbackup.models.RecoveryPoint;
import com.azure.resourcemanager.recoveryservicesbackup.models.RecoveryPointResourceList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class RecoveryPointResourceListTests {
    @Test
    public void testDeserialize() {
        RecoveryPointResourceList model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"properties\":{\"objectType\":\"RecoveryPoint\"},\"eTag\":\"watkpnpulexxb\",\"location\":\"zwtruwiqzbqjvsov\",\"tags\":{\"hzdobpxjmflbvvnc\":\"kacspkw\",\"rsa\":\"rkcciwwzjuqk\"},\"id\":\"iwkuofos\",\"name\":\"ghsauuimjmvxied\",\"type\":\"ugidyjrr\"},{\"properties\":{\"objectType\":\"RecoveryPoint\"},\"eTag\":\"aos\",\"location\":\"e\",\"tags\":{\"hocohslkev\":\"onpc\",\"hfmvfaxkffe\":\"eggzfb\",\"sbbzo\":\"ithlvmezyvshxm\"},\"id\":\"gigr\",\"name\":\"wburvjxxjnspydpt\",\"type\":\"oenkouknvudwti\"},{\"properties\":{\"objectType\":\"RecoveryPoint\"},\"eTag\":\"ldngkpoci\",\"location\":\"azyxoegukg\",\"tags\":{\"yp\":\"iucgygevqzn\"},\"id\":\"rbpizc\",\"name\":\"r\",\"type\":\"j\"}],\"nextLink\":\"pyd\"}")
                .toObject(RecoveryPointResourceList.class);
        Assertions.assertEquals("pyd", model.nextLink());
        Assertions.assertEquals("zwtruwiqzbqjvsov", model.value().get(0).location());
        Assertions.assertEquals("kacspkw", model.value().get(0).tags().get("hzdobpxjmflbvvnc"));
        Assertions.assertEquals("watkpnpulexxb", model.value().get(0).etag());
    }

    @Test
    public void testSerialize() {
        RecoveryPointResourceList model =
            new RecoveryPointResourceList()
                .withNextLink("pyd")
                .withValue(
                    Arrays
                        .asList(
                            new RecoveryPointResourceInner()
                                .withLocation("zwtruwiqzbqjvsov")
                                .withTags(mapOf("hzdobpxjmflbvvnc", "kacspkw", "rsa", "rkcciwwzjuqk"))
                                .withProperties(new RecoveryPoint())
                                .withEtag("watkpnpulexxb"),
                            new RecoveryPointResourceInner()
                                .withLocation("e")
                                .withTags(
                                    mapOf("hocohslkev", "onpc", "hfmvfaxkffe", "eggzfb", "sbbzo", "ithlvmezyvshxm"))
                                .withProperties(new RecoveryPoint())
                                .withEtag("aos"),
                            new RecoveryPointResourceInner()
                                .withLocation("azyxoegukg")
                                .withTags(mapOf("yp", "iucgygevqzn"))
                                .withProperties(new RecoveryPoint())
                                .withEtag("ldngkpoci")));
        model = BinaryData.fromObject(model).toObject(RecoveryPointResourceList.class);
        Assertions.assertEquals("pyd", model.nextLink());
        Assertions.assertEquals("zwtruwiqzbqjvsov", model.value().get(0).location());
        Assertions.assertEquals("kacspkw", model.value().get(0).tags().get("hzdobpxjmflbvvnc"));
        Assertions.assertEquals("watkpnpulexxb", model.value().get(0).etag());
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
