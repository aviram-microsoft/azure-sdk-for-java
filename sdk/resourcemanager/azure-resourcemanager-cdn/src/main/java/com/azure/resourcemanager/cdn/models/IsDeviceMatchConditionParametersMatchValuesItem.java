// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cdn.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for IsDeviceMatchConditionParametersMatchValuesItem. */
public final class IsDeviceMatchConditionParametersMatchValuesItem
    extends ExpandableStringEnum<IsDeviceMatchConditionParametersMatchValuesItem> {
    /** Static value Mobile for IsDeviceMatchConditionParametersMatchValuesItem. */
    public static final IsDeviceMatchConditionParametersMatchValuesItem MOBILE = fromString("Mobile");

    /** Static value Desktop for IsDeviceMatchConditionParametersMatchValuesItem. */
    public static final IsDeviceMatchConditionParametersMatchValuesItem DESKTOP = fromString("Desktop");

    /**
     * Creates or finds a IsDeviceMatchConditionParametersMatchValuesItem from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding IsDeviceMatchConditionParametersMatchValuesItem.
     */
    @JsonCreator
    public static IsDeviceMatchConditionParametersMatchValuesItem fromString(String name) {
        return fromString(name, IsDeviceMatchConditionParametersMatchValuesItem.class);
    }

    /**
     * Gets known IsDeviceMatchConditionParametersMatchValuesItem values.
     *
     * @return known IsDeviceMatchConditionParametersMatchValuesItem values.
     */
    public static Collection<IsDeviceMatchConditionParametersMatchValuesItem> values() {
        return values(IsDeviceMatchConditionParametersMatchValuesItem.class);
    }
}
