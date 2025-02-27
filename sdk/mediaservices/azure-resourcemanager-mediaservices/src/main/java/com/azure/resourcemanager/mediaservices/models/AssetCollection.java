// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.mediaservices.fluent.models.AssetInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** A collection of Asset items. */
@Fluent
public final class AssetCollection {
    /*
     * A collection of Asset items.
     */
    @JsonProperty(value = "value")
    private List<AssetInner> value;

    /*
     * A link to the next page of the collection (when the collection contains too many results to return in one
     * response).
     */
    @JsonProperty(value = "@odata.nextLink")
    private String odataNextLink;

    /**
     * Get the value property: A collection of Asset items.
     *
     * @return the value value.
     */
    public List<AssetInner> value() {
        return this.value;
    }

    /**
     * Set the value property: A collection of Asset items.
     *
     * @param value the value value to set.
     * @return the AssetCollection object itself.
     */
    public AssetCollection withValue(List<AssetInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the odataNextLink property: A link to the next page of the collection (when the collection contains too many
     * results to return in one response).
     *
     * @return the odataNextLink value.
     */
    public String odataNextLink() {
        return this.odataNextLink;
    }

    /**
     * Set the odataNextLink property: A link to the next page of the collection (when the collection contains too many
     * results to return in one response).
     *
     * @param odataNextLink the odataNextLink value to set.
     * @return the AssetCollection object itself.
     */
    public AssetCollection withOdataNextLink(String odataNextLink) {
        this.odataNextLink = odataNextLink;
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
