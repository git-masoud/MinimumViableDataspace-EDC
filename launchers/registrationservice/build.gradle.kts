/*
 *  Copyright (c) 2022 Microsoft Corporation
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

dependencies {
    implementation(libs.registrationService.core)
    implementation(libs.registrationService.core.credential.service)
    implementation(libs.registrationService.api)

    implementation(libs.edc.identity.did.web)
    implementation(libs.edc.identity.did.core)
    implementation(libs.edc.core.connector)
    runtimeOnly(libs.edc.boot)
    implementation(libs.edc.core.controlplane)
    implementation(libs.edc.api.observability)
    implementation(libs.edc.micrometer.core)
    runtimeOnly(libs.edc.micrometer.jetty)
    runtimeOnly(libs.edc.micrometer.jersey)
    implementation(libs.edc.config.filesystem)
    implementation(libs.identityHub.api)
    implementation(libs.identityHub.selfdescription.api)
    implementation(libs.identityHub.core.verifier)
    implementation(libs.identityHub.credentials.jwt)
    implementation(libs.identityHub.verifier.jwt)

    // To use FileSystem vault e.g. -DuseFsVault="true".Only for non-production usages.
    val useFsVault: Boolean = System.getProperty("useFsVault", "false").toBoolean()
    if (useFsVault) {
        implementation(libs.edc.vault.filesystem)
    } else {
        implementation(libs.edc.azure.vault)
    }
}

application {
    mainClass.set("org.eclipse.edc.boot.system.runtime.BaseRuntime")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    mergeServiceFiles()
    archiveFileName.set("app.jar")
}
