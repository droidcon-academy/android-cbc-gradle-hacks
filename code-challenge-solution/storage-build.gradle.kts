plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.droidcon.storage"
}

dependencies {
    testImplementation(libs.junit)
}
