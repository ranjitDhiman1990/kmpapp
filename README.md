# Kotlin Multiplatform Compose Demo App - Step-by-Step Setup Guide

This guide provides a step-by-step walkthrough of setting up a Kotlin Multiplatform (KMP) project with Compose, targeting Android, iOS, and JVM (Desktop). We'll focus on understanding each step without getting bogged down in excessive code.
Check Youtube Video Link - https://youtu.be/fmFezt-2IBo?si=PagBXIdgnx-03DD9
## 1. Creating the initial `settings.gradle.kts`

1.  Create a `settings.gradle.kts` file in the root directory.
2.  Declare the repositories from where dependencies can be downloaded (Gradle Plugin Portal, Maven Central).
3.  Declare the modules in the project (e.g., `:app` for the Android application).

## 2. Loading the Kotlin Multiplatform Plugin

1.  Create a `build.gradle.kts` file in the root directory.
2.  Declare the Kotlin Multiplatform plugin using `alias(libs.plugins.kotlin.multiplatform) apply false`.  The `apply false` part ensures it's loaded but not applied to the root project.

## 3. Loading the Android Application Plugin

1.  In the root `build.gradle.kts` file, also load the Android Application plugin: `alias(libs.plugins.android.application) apply false`.
2.  If you are using Google dependencies, add the Google repository in `settings.gradle.kts` with content filtering to only ask for Android or Google-related artifacts.

## 4. Setting up the `:app` module

1.  Create an `app` directory.
2.  Create a `build.gradle.kts` file inside the `app` directory.
3.  Apply the Kotlin Multiplatform and Android Application plugins: `alias(libs.plugins.kotlin.multiplatform)`, `alias(libs.plugins.android.application)`.
4.  Define the Kotlin targets: `androidTarget`, `jvm("desktop")`, `iosX64()`, `iosArm64()`, `iosSimulatorArm64()`.
5.  Configure source sets: `commonMain`, `androidMain`, and `desktopMain`.
6.  Configure Android-specific settings like `namespace`, `compileSdk`, `minSdk`, `targetSdk`, `applicationId`, and enable Compose with `buildFeatures { compose = true }`.

## 5. Setup the compose plugins

1.  Load the Compose plugins in the root `build.gradle.kts`: `alias(libs.plugins.jetbrains.compose) apply false`.
2.  Apply the Compose plugins in the `app` module's `build.gradle.kts`: `alias(libs.plugins.jetbrains.compose)`.

## 6. Writing the first `@Composable` functions

1.  Create a `MainScreen.kt` file under `app/src/commonMain/kotlin/<your_package>`.
2.  Write a `@Composable` function (e.g., `MainScreen`) that will be shared across platforms.
3.  Add Compose dependencies in the `commonMain` source set (compose.runtime, compose.foundation, compose.material3).

## 7. Creating the MainActivity

1.  Create a `MainActivity.kt` file under `app/src/androidMain/kotlin/<your_package>`.
2.  Implement `AppCompatActivity` and override `onCreate`.
3.  Use `setContent { MainScreen() }` to set the content to your shared composable.
4.  Create `AndroidManifest.xml` file under `app/src/androidMain/`.
    *   Declare the activity and intent filter.

## 8. Creating the .frameworks

Creating the .frameworks is platform specific and is not covered in the transcript

## 9. Setting up Xcode

Setting up Xcode is platform specific and is not covered in the transcript

## 10. Creating the ViewController

Creating the ViewController is platform specific and is not covered in the transcript

## 11. Setting up the Desktop Target

1.  Modify the `build.gradle.kts` file inside the `app` directory.
2.  Configure the JVM target.
3.  Create the `Main.kt` file inside the `app/src/desktopMain/kotlin/` directory.
4.  Run the application using `./gradlew run` command.
