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
 *       Microsoft Corporation - initial implementation
 *
 */

plugins {
    `java-library`
}

dependencies {
    api(libs.edc.spi.dsp)
    api(libs.edc.spi.contract)
    api(libs.edc.core.connector)
    implementation(libs.identityHub.spi.core)

    testImplementation(libs.edc.policy.engine)
}
