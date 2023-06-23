/*
 *  Copyright (c) 2020, 2021 Microsoft Corporation
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Microsoft Corporation - initial API and implementation
 *
 */

plugins {
    `java-library`
    id("application")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

val edcGroup: String by project

dependencies {
    implementation(project(":extensions:refresh-catalog"))
    implementation(project(":extensions:policies"))

    implementation(libs.edc.core.controlplane)
    implementation(libs.edc.api.observability)
    implementation(libs.edc.api.management)
    implementation(libs.edc.config.filesystem)
    implementation(libs.edc.ext.http)
    
    // IDS
    implementation(libs.edc.dsp) {
        // Workaround for https://github.com/eclipse-dataspaceconnector/DataSpaceConnector/issues/1387
        exclude(group = edcGroup, module = "ids-token-validation")
    }

    // API key authentication for Data Management API (also used for CORS support)

    implementation(libs.edc.auth.tokenBased)

    // DID authentication for IDS API
    implementation(libs.bundles.edc.identity)

    // Blob storage container provisioning
    implementation(libs.edc.azure.core.blob)
    implementation(libs.edc.azure.provision.blob)
    // To use FileSystem vault e.g. -DuseFsVault="true".Only for non-production usages.
    val useFsVault: Boolean = System.getProperty("useFsVault", "true").toBoolean()
    if (useFsVault) {
        implementation(libs.edc.vault.filesystem)
    } else {
        implementation(libs.edc.azure.vault)
    }

    // Embedded DPF
    implementation(libs.bundles.edc.dpf)

    // Federated catalog
    implementation(libs.fcc.core)
    implementation(libs.fcc.api)

    // Identity Hub
    implementation(libs.identityHub.core)
    implementation(libs.identityHub.api)
    implementation(libs.identityHub.selfdescription.api)
    implementation(libs.identityHub.core.verifier)
    implementation(libs.identityHub.credentials.jwt)
    implementation(libs.identityHub.verifier.jwt)
}

application {
    mainClass.set("org.eclipse.edc.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    mergeServiceFiles()
    archiveFileName.set("app.jar")
}
