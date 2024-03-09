@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.example.base"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation (libs.converter.gson)
    implementation(libs.gson)


    implementation(libs.retrofit)
    implementation(libs.kotlinx.coroutines)


    implementation(libs.logging.interceptor)

    implementation(libs.androidx.paging.runtime.ktx)

    implementation(project(":backend"))
    implementation(project(":data:base"))
}