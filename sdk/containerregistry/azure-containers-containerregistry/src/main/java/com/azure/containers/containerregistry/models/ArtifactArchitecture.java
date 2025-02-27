// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.containers.containerregistry.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** The artifact platform's architecture. */
public final class ArtifactArchitecture extends ExpandableStringEnum<ArtifactArchitecture> {
    /** Static value 386 for ArtifactArchitecture. */
    public static final ArtifactArchitecture I386 = fromString("386");

    /** Static value amd64 for ArtifactArchitecture. */
    public static final ArtifactArchitecture AMD64 = fromString("amd64");

    /** Static value arm for ArtifactArchitecture. */
    public static final ArtifactArchitecture ARM = fromString("arm");

    /** Static value arm64 for ArtifactArchitecture. */
    public static final ArtifactArchitecture ARM64 = fromString("arm64");

    /** Static value mips for ArtifactArchitecture. */
    public static final ArtifactArchitecture MIPS = fromString("mips");

    /** Static value mipsle for ArtifactArchitecture. */
    public static final ArtifactArchitecture MIPS_LE = fromString("mipsle");

    /** Static value mips64 for ArtifactArchitecture. */
    public static final ArtifactArchitecture MIPS64 = fromString("mips64");

    /** Static value mips64le for ArtifactArchitecture. */
    public static final ArtifactArchitecture MIPS64LE = fromString("mips64le");

    /** Static value ppc64 for ArtifactArchitecture. */
    public static final ArtifactArchitecture PPC64 = fromString("ppc64");

    /** Static value ppc64le for ArtifactArchitecture. */
    public static final ArtifactArchitecture PPC64LE = fromString("ppc64le");

    /** Static value riscv64 for ArtifactArchitecture. */
    public static final ArtifactArchitecture RISC_V64 = fromString("riscv64");

    /** Static value s390x for ArtifactArchitecture. */
    public static final ArtifactArchitecture S390X = fromString("s390x");

    /** Static value wasm for ArtifactArchitecture. */
    public static final ArtifactArchitecture WASM = fromString("wasm");

    /**
     * Creates or finds a ArtifactArchitecture from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding ArtifactArchitecture.
     */
    @JsonCreator
    public static ArtifactArchitecture fromString(String name) {
        return fromString(name, ArtifactArchitecture.class);
    }

    /**
     * Gets known ArtifactArchitecture values.
     *
     * @return known ArtifactArchitecture values.
     */
    public static Collection<ArtifactArchitecture> values() {
        return values(ArtifactArchitecture.class);
    }
}
