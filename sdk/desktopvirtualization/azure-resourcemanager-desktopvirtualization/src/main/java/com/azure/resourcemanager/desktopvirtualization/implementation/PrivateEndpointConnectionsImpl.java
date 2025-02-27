// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.desktopvirtualization.fluent.PrivateEndpointConnectionsClient;
import com.azure.resourcemanager.desktopvirtualization.fluent.models.PrivateEndpointConnectionWithSystemDataInner;
import com.azure.resourcemanager.desktopvirtualization.models.PrivateEndpointConnection;
import com.azure.resourcemanager.desktopvirtualization.models.PrivateEndpointConnectionWithSystemData;
import com.azure.resourcemanager.desktopvirtualization.models.PrivateEndpointConnections;

public final class PrivateEndpointConnectionsImpl implements PrivateEndpointConnections {
    private static final ClientLogger LOGGER = new ClientLogger(PrivateEndpointConnectionsImpl.class);

    private final PrivateEndpointConnectionsClient innerClient;

    private final com.azure.resourcemanager.desktopvirtualization.DesktopVirtualizationManager serviceManager;

    public PrivateEndpointConnectionsImpl(
        PrivateEndpointConnectionsClient innerClient,
        com.azure.resourcemanager.desktopvirtualization.DesktopVirtualizationManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<PrivateEndpointConnectionWithSystemData> listByHostPool(
        String resourceGroupName, String hostPoolName) {
        PagedIterable<PrivateEndpointConnectionWithSystemDataInner> inner =
            this.serviceClient().listByHostPool(resourceGroupName, hostPoolName);
        return Utils.mapPage(inner, inner1 -> new PrivateEndpointConnectionWithSystemDataImpl(inner1, this.manager()));
    }

    public PagedIterable<PrivateEndpointConnectionWithSystemData> listByHostPool(
        String resourceGroupName, String hostPoolName, Context context) {
        PagedIterable<PrivateEndpointConnectionWithSystemDataInner> inner =
            this.serviceClient().listByHostPool(resourceGroupName, hostPoolName, context);
        return Utils.mapPage(inner, inner1 -> new PrivateEndpointConnectionWithSystemDataImpl(inner1, this.manager()));
    }

    public PrivateEndpointConnectionWithSystemData getByHostPool(
        String resourceGroupName, String hostPoolName, String privateEndpointConnectionName) {
        PrivateEndpointConnectionWithSystemDataInner inner =
            this.serviceClient().getByHostPool(resourceGroupName, hostPoolName, privateEndpointConnectionName);
        if (inner != null) {
            return new PrivateEndpointConnectionWithSystemDataImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<PrivateEndpointConnectionWithSystemData> getByHostPoolWithResponse(
        String resourceGroupName, String hostPoolName, String privateEndpointConnectionName, Context context) {
        Response<PrivateEndpointConnectionWithSystemDataInner> inner =
            this
                .serviceClient()
                .getByHostPoolWithResponse(resourceGroupName, hostPoolName, privateEndpointConnectionName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new PrivateEndpointConnectionWithSystemDataImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public void deleteByHostPool(String resourceGroupName, String hostPoolName, String privateEndpointConnectionName) {
        this.serviceClient().deleteByHostPool(resourceGroupName, hostPoolName, privateEndpointConnectionName);
    }

    public Response<Void> deleteByHostPoolWithResponse(
        String resourceGroupName, String hostPoolName, String privateEndpointConnectionName, Context context) {
        return this
            .serviceClient()
            .deleteByHostPoolWithResponse(resourceGroupName, hostPoolName, privateEndpointConnectionName, context);
    }

    public PrivateEndpointConnectionWithSystemData updateByHostPool(
        String resourceGroupName,
        String hostPoolName,
        String privateEndpointConnectionName,
        PrivateEndpointConnection connection) {
        PrivateEndpointConnectionWithSystemDataInner inner =
            this
                .serviceClient()
                .updateByHostPool(resourceGroupName, hostPoolName, privateEndpointConnectionName, connection);
        if (inner != null) {
            return new PrivateEndpointConnectionWithSystemDataImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<PrivateEndpointConnectionWithSystemData> updateByHostPoolWithResponse(
        String resourceGroupName,
        String hostPoolName,
        String privateEndpointConnectionName,
        PrivateEndpointConnection connection,
        Context context) {
        Response<PrivateEndpointConnectionWithSystemDataInner> inner =
            this
                .serviceClient()
                .updateByHostPoolWithResponse(
                    resourceGroupName, hostPoolName, privateEndpointConnectionName, connection, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new PrivateEndpointConnectionWithSystemDataImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public PagedIterable<PrivateEndpointConnectionWithSystemData> listByWorkspace(
        String resourceGroupName, String workspaceName) {
        PagedIterable<PrivateEndpointConnectionWithSystemDataInner> inner =
            this.serviceClient().listByWorkspace(resourceGroupName, workspaceName);
        return Utils.mapPage(inner, inner1 -> new PrivateEndpointConnectionWithSystemDataImpl(inner1, this.manager()));
    }

    public PagedIterable<PrivateEndpointConnectionWithSystemData> listByWorkspace(
        String resourceGroupName, String workspaceName, Context context) {
        PagedIterable<PrivateEndpointConnectionWithSystemDataInner> inner =
            this.serviceClient().listByWorkspace(resourceGroupName, workspaceName, context);
        return Utils.mapPage(inner, inner1 -> new PrivateEndpointConnectionWithSystemDataImpl(inner1, this.manager()));
    }

    public PrivateEndpointConnectionWithSystemData getByWorkspace(
        String resourceGroupName, String workspaceName, String privateEndpointConnectionName) {
        PrivateEndpointConnectionWithSystemDataInner inner =
            this.serviceClient().getByWorkspace(resourceGroupName, workspaceName, privateEndpointConnectionName);
        if (inner != null) {
            return new PrivateEndpointConnectionWithSystemDataImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<PrivateEndpointConnectionWithSystemData> getByWorkspaceWithResponse(
        String resourceGroupName, String workspaceName, String privateEndpointConnectionName, Context context) {
        Response<PrivateEndpointConnectionWithSystemDataInner> inner =
            this
                .serviceClient()
                .getByWorkspaceWithResponse(resourceGroupName, workspaceName, privateEndpointConnectionName, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new PrivateEndpointConnectionWithSystemDataImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public void deleteByWorkspace(
        String resourceGroupName, String workspaceName, String privateEndpointConnectionName) {
        this.serviceClient().deleteByWorkspace(resourceGroupName, workspaceName, privateEndpointConnectionName);
    }

    public Response<Void> deleteByWorkspaceWithResponse(
        String resourceGroupName, String workspaceName, String privateEndpointConnectionName, Context context) {
        return this
            .serviceClient()
            .deleteByWorkspaceWithResponse(resourceGroupName, workspaceName, privateEndpointConnectionName, context);
    }

    public PrivateEndpointConnectionWithSystemData updateByWorkspace(
        String resourceGroupName,
        String workspaceName,
        String privateEndpointConnectionName,
        PrivateEndpointConnection connection) {
        PrivateEndpointConnectionWithSystemDataInner inner =
            this
                .serviceClient()
                .updateByWorkspace(resourceGroupName, workspaceName, privateEndpointConnectionName, connection);
        if (inner != null) {
            return new PrivateEndpointConnectionWithSystemDataImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<PrivateEndpointConnectionWithSystemData> updateByWorkspaceWithResponse(
        String resourceGroupName,
        String workspaceName,
        String privateEndpointConnectionName,
        PrivateEndpointConnection connection,
        Context context) {
        Response<PrivateEndpointConnectionWithSystemDataInner> inner =
            this
                .serviceClient()
                .updateByWorkspaceWithResponse(
                    resourceGroupName, workspaceName, privateEndpointConnectionName, connection, context);
        if (inner != null) {
            return new SimpleResponse<>(
                inner.getRequest(),
                inner.getStatusCode(),
                inner.getHeaders(),
                new PrivateEndpointConnectionWithSystemDataImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    private PrivateEndpointConnectionsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.desktopvirtualization.DesktopVirtualizationManager manager() {
        return this.serviceManager;
    }
}
