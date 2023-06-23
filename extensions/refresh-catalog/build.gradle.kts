plugins {
    `java-library`
}

dependencies {
    implementation(libs.fcc.spi)
    implementation(libs.edc.spi.dsp)
    implementation(libs.edc.spi.http.dsp)
    implementation(libs.edc.util)
    implementation(libs.edc.identity.did.core)
    implementation(libs.edc.identity.did.web)
    implementation(libs.registrationService.core.client)
    implementation(libs.registrationService.api)
    testImplementation(libs.registrationService.api)
}
