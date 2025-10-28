plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.theolaforgeeval.features.client.home.data"
    compileSdk = 36

    buildTypes {
        release {
            isMinifyEnabled = false
        }
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
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":features:client:home:domain"))

    implementation(libs.bundles.common.core)
    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.bundles.koin)
    implementation(libs.bundles.room)
}