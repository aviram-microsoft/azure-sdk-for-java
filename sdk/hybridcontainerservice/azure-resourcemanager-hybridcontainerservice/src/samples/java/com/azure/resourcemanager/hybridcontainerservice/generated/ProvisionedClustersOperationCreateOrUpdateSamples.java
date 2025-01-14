// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcontainerservice.generated;

import com.azure.resourcemanager.hybridcontainerservice.models.CloudProviderProfile;
import com.azure.resourcemanager.hybridcontainerservice.models.CloudProviderProfileInfraNetworkProfile;
import com.azure.resourcemanager.hybridcontainerservice.models.CloudProviderProfileInfraStorageProfile;
import com.azure.resourcemanager.hybridcontainerservice.models.ControlPlaneProfile;
import com.azure.resourcemanager.hybridcontainerservice.models.LinuxProfileProperties;
import com.azure.resourcemanager.hybridcontainerservice.models.LinuxProfilePropertiesSsh;
import com.azure.resourcemanager.hybridcontainerservice.models.LinuxProfilePropertiesSshPublicKeysItem;
import com.azure.resourcemanager.hybridcontainerservice.models.LoadBalancerProfile;
import com.azure.resourcemanager.hybridcontainerservice.models.LoadBalancerSku;
import com.azure.resourcemanager.hybridcontainerservice.models.NamedAgentPoolProfile;
import com.azure.resourcemanager.hybridcontainerservice.models.NetworkPolicy;
import com.azure.resourcemanager.hybridcontainerservice.models.NetworkProfile;
import com.azure.resourcemanager.hybridcontainerservice.models.OsType;
import com.azure.resourcemanager.hybridcontainerservice.models.ProvisionedClustersAllProperties;
import com.azure.resourcemanager.hybridcontainerservice.models.ProvisionedClustersExtendedLocation;
import java.util.Arrays;

/** Samples for ProvisionedClustersOperation CreateOrUpdate. */
public final class ProvisionedClustersOperationCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/hybridaks/resource-manager/Microsoft.HybridContainerService/preview/2022-05-01-preview/examples/PutProvisionedCluster.json
     */
    /**
     * Sample code: PutProvisionedCluster.
     *
     * @param manager Entry point to HybridContainerServiceManager.
     */
    public static void putProvisionedCluster(
        com.azure.resourcemanager.hybridcontainerservice.HybridContainerServiceManager manager) {
        manager
            .provisionedClustersOperations()
            .define("test-hybridakscluster")
            .withRegion("westus")
            .withExistingResourceGroup("test-arcappliance-resgrp")
            .withProperties(
                new ProvisionedClustersAllProperties()
                    .withLinuxProfile(
                        new LinuxProfileProperties()
                            .withSsh(
                                new LinuxProfilePropertiesSsh()
                                    .withPublicKeys(
                                        Arrays
                                            .asList(
                                                new LinuxProfilePropertiesSshPublicKeysItem()
                                                    .withKeyData("ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQCY.......")))))
                    .withControlPlane(
                        new ControlPlaneProfile()
                            .withCount(1)
                            .withOsType(OsType.LINUX)
                            .withVmSize("Standard_A4_v2")
                            .withLinuxProfile(
                                new LinuxProfileProperties()
                                    .withSsh(
                                        new LinuxProfilePropertiesSsh()
                                            .withPublicKeys(
                                                Arrays
                                                    .asList(
                                                        new LinuxProfilePropertiesSshPublicKeysItem()
                                                            .withKeyData(
                                                                "ssh-rsa AAAAB1NzaC1yc2EAAAADAQABAAACAQCY......"))))))
                    .withKubernetesVersion("v1.20.5")
                    .withNetworkProfile(
                        new NetworkProfile()
                            .withLoadBalancerProfile(
                                new LoadBalancerProfile()
                                    .withCount(1)
                                    .withOsType(OsType.LINUX)
                                    .withVmSize("Standard_K8S3_v1")
                                    .withLinuxProfile(
                                        new LinuxProfileProperties()
                                            .withSsh(
                                                new LinuxProfilePropertiesSsh()
                                                    .withPublicKeys(
                                                        Arrays
                                                            .asList(
                                                                new LinuxProfilePropertiesSshPublicKeysItem()
                                                                    .withKeyData(
                                                                        "ssh-rsa"
                                                                            + " AAAAB2NzaC1yc2EAAAADAQABAAACAQCY......"))))))
                            .withLoadBalancerSku(LoadBalancerSku.UNSTACKED_HAPROXY)
                            .withNetworkPolicy(NetworkPolicy.CALICO)
                            .withPodCidr("10.244.0.0/16"))
                    .withAgentPoolProfiles(
                        Arrays
                            .asList(
                                new NamedAgentPoolProfile()
                                    .withCount(1)
                                    .withOsType(OsType.LINUX)
                                    .withVmSize("Standard_A4_v2")
                                    .withName("default-nodepool-1")))
                    .withCloudProviderProfile(
                        new CloudProviderProfile()
                            .withInfraNetworkProfile(
                                new CloudProviderProfileInfraNetworkProfile()
                                    .withVnetSubnetIds(
                                        Arrays
                                            .asList(
                                                "/subscriptions/a3e42606-29b1-4d7d-b1d9-9ff6b9d3c71b/resourceGroups/test-arcappliance-resgrp/providers/Microsoft.HybridContainerService/virtualNetworks/test-vnet-static")))
                            .withInfraStorageProfile(
                                new CloudProviderProfileInfraStorageProfile()
                                    .withStorageSpaceIds(
                                        Arrays
                                            .asList(
                                                "/subscriptions/a3e42606-29b1-4d7d-b1d9-9ff6b9d3c71b/resourceGroups/test-arcappliance-resgrp/providers/Microsoft.HybridContainerService/storageSpaces/test-storage")))))
            .withExtendedLocation(
                new ProvisionedClustersExtendedLocation()
                    .withType("CustomLocation")
                    .withName(
                        "/subscriptions/a3e42606-29b1-4d7d-b1d9-9ff6b9d3c71b/resourcegroups/test-arcappliance-resgrp/providers/microsoft.extendedlocation/customlocations/testcustomlocation"))
            .create();
    }
}
