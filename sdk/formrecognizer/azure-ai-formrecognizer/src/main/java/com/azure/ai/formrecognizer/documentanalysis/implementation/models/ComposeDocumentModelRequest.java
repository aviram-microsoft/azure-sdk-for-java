// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.formrecognizer.documentanalysis.implementation.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/** Request body to create a composed document model from component document models. */
@Fluent
public final class ComposeDocumentModelRequest {
    /*
     * Unique document model name.
     */
    @JsonProperty(value = "modelId", required = true)
    private String modelId;

    /*
     * Document model description.
     */
    @JsonProperty(value = "description")
    private String description;

    /*
     * List of component document models to compose.
     */
    @JsonProperty(value = "componentModels", required = true)
    private List<ComponentDocumentModelDetails> componentModels;

    /*
     * List of key-value tag attributes associated with the document model.
     */
    @JsonProperty(value = "tags")
    private Map<String, String> tags;

    /** Creates an instance of ComposeDocumentModelRequest class. */
    public ComposeDocumentModelRequest() {}

    /**
     * Get the modelId property: Unique document model name.
     *
     * @return the modelId value.
     */
    public String getModelId() {
        return this.modelId;
    }

    /**
     * Set the modelId property: Unique document model name.
     *
     * @param modelId the modelId value to set.
     * @return the ComposeDocumentModelRequest object itself.
     */
    public ComposeDocumentModelRequest setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    /**
     * Get the description property: Document model description.
     *
     * @return the description value.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description property: Document model description.
     *
     * @param description the description value to set.
     * @return the ComposeDocumentModelRequest object itself.
     */
    public ComposeDocumentModelRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the componentModels property: List of component document models to compose.
     *
     * @return the componentModels value.
     */
    public List<ComponentDocumentModelDetails> getComponentModels() {
        return this.componentModels;
    }

    /**
     * Set the componentModels property: List of component document models to compose.
     *
     * @param componentModels the componentModels value to set.
     * @return the ComposeDocumentModelRequest object itself.
     */
    public ComposeDocumentModelRequest setComponentModels(List<ComponentDocumentModelDetails> componentModels) {
        this.componentModels = componentModels;
        return this;
    }

    /**
     * Get the tags property: List of key-value tag attributes associated with the document model.
     *
     * @return the tags value.
     */
    public Map<String, String> getTags() {
        return this.tags;
    }

    /**
     * Set the tags property: List of key-value tag attributes associated with the document model.
     *
     * @param tags the tags value to set.
     * @return the ComposeDocumentModelRequest object itself.
     */
    public ComposeDocumentModelRequest setTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }
}
