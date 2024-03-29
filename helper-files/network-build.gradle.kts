plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.9.22"
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.droidcon.network"
}

dependencies {
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.11.0")

    implementation ("io.ktor:ktor-client-core:2.3.8")
    implementation ("io.ktor:ktor-client-android:2.3.8")
    implementation ("io.ktor:ktor-client-logging:2.3.8")
    implementation ("io.ktor:ktor-client-content-negotiation:2.3.8")
    implementation ("io.ktor:ktor-serialization-kotlinx-json:2.3.5")

    implementation ("com.google.dagger:hilt-android:2.50")
    kapt ("com.google.dagger:hilt-compiler:2.50")

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
}
