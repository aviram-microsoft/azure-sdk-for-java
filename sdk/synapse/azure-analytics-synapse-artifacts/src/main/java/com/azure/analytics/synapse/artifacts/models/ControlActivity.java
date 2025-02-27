// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/** Base class for all control activities like IfCondition, ForEach , Until. */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        defaultImpl = ControlActivity.class)
@JsonTypeName("Container")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "ExecutePipeline", value = ExecutePipelineActivity.class),
    @JsonSubTypes.Type(name = "IfCondition", value = IfConditionActivity.class),
    @JsonSubTypes.Type(name = "Switch", value = SwitchActivity.class),
    @JsonSubTypes.Type(name = "ForEach", value = ForEachActivity.class),
    @JsonSubTypes.Type(name = "Wait", value = WaitActivity.class),
    @JsonSubTypes.Type(name = "Fail", value = FailActivity.class),
    @JsonSubTypes.Type(name = "Until", value = UntilActivity.class),
    @JsonSubTypes.Type(name = "Validation", value = ValidationActivity.class),
    @JsonSubTypes.Type(name = "Filter", value = FilterActivity.class),
    @JsonSubTypes.Type(name = "SetVariable", value = SetVariableActivity.class),
    @JsonSubTypes.Type(name = "AppendVariable", value = AppendVariableActivity.class),
    @JsonSubTypes.Type(name = "WebHook", value = WebHookActivity.class)
})
@Fluent
public class ControlActivity extends Activity {
    /** {@inheritDoc} */
    @Override
    public ControlActivity setName(String name) {
        super.setName(name);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ControlActivity setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ControlActivity setDependsOn(List<ActivityDependency> dependsOn) {
        super.setDependsOn(dependsOn);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public ControlActivity setUserProperties(List<UserProperty> userProperties) {
        super.setUserProperties(userProperties);
        return this;
    }
}
