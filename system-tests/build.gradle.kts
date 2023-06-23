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
 *       Bayerische Motoren Werke Aktiengesellschaft (BMW AG)
 *
 */

plugins {
    `java-library`
}

val gatlingVersion: String by project

dependencies {
    testImplementation(libs.gatling.highcharts) {
        exclude(group = "io.gatling", module = "gatling-jms")
        exclude(group = "io.gatling", module = "gatling-jms-java")
        exclude(group = "io.gatling", module = "gatling-mqtt")
        exclude(group = "io.gatling", module = "gatling-mqtt-java")
        exclude(group = "io.gatling", module = "gatling-jdbc")
        exclude(group = "io.gatling", module = "gatling-jdbc-java")
        exclude(group = "io.gatling", module = "gatling-redis")
        exclude(group = "io.gatling", module = "gatling-redis-java")
        exclude(group = "io.gatling", module = "gatling-graphite")
    }

    testImplementation(libs.apache.commons.lang3)
  testImplementation("com.azure.resourcemanager:azure-resourcemanager-storage:2.12.0")
    testImplementation("com.azure:azure-storage-blob:12.19.1")
    testImplementation(libs.edc.azure.core.blob)
    testImplementation(libs.edc.util)
    testImplementation(libs.edc.azure.storage.blob)
    testImplementation(libs.restAssured)
    testImplementation(libs.awaitility)
    testImplementation(libs.okhttp)

    testImplementation(libs.azure.identity)
    testImplementation(libs.azure.keyvault)
    testImplementation(libs.edc.spi.contract)
    testImplementation(libs.fcc.spi)
    testImplementation(libs.edc.policy.evaluator)

    // Identity Hub
    testImplementation(libs.identityHub.core.client)
    testImplementation(libs.identityHub.credentials.jwt)
    testImplementation(libs.edc.junit)
}

