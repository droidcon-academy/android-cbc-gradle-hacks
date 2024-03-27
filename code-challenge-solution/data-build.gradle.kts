plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    id(libs.plugins.kotlin.serialization.get().pluginId)
    kotlin("kapt")
}

android {
    namespace = "com.droidcon.data"
}

dependencies {
    implementation(projects.network)

    implementation(libs.ktor.serialization)
    implementation(libs.ktor.client.core)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
}
