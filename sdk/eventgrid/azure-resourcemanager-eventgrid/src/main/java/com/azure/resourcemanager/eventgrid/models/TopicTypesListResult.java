// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.eventgrid.fluent.models.TopicTypeInfoInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Result of the List Topic Types operation. */
@Fluent
public final class TopicTypesListResult {
    /*
     * A collection of topic types
     */
    @JsonProperty(value = "value")
    private List<TopicTypeInfoInner> value;

    /**
     * Get the value property: A collection of topic types.
     *
     * @return the value value.
     */
    public List<TopicTypeInfoInner> value() {
        return this.value;
    }

    /**
     * Set the value property: A collection of topic types.
     *
     * @param value the value value to set.
     * @return the TopicTypesListResult object itself.
     */
    public TopicTypesListResult withValue(List<TopicTypeInfoInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }
}
