import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinAndroidTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.compose")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    jvmToolchain(17)

    jvm()
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets.commonMain.dependencies {
        implementation(compose.runtime)
        implementation(compose.foundation)
        implementation(compose.material3)
    }

    sourceSets.androidMain.dependencies {
        implementation("androidx.activity:activity-compose:1.10.1")
        implementation("androidx.appcompat:appcompat:1.7.0")
    }
}

android {
    namespace = "io.dhiman.kmp"
    compileSdk = 35
    defaultConfig {
        applicationId = "io.dhiman.kmp"
        minSdk = 21
        targetSdk = 35
    }
}

kotlin.targets.withType<KotlinNativeTarget>().configureEach {
    binaries.framework {
        baseName = "KmpApp"
        isStatic = true
    }
}