import org.gradle.api.internal.initialization.ClassLoaderIds.buildScript

plugins {
    //id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
}

android {
    namespace = "edu.sfsu.googlemap"
    compileSdk = 34

    defaultConfig {
        applicationId = "edu.sfsu.googlemap"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }

    secrets {
        propertiesFileName = "secrets.properties"

        defaultPropertiesFileName = "local.defaults.properties"

        ignoreList.add("keyToIgnore")
        ignoreList.add("sdk.*")
    }
}

/**
 * This is the "Module Level" build.gradle file
 */
dependencies {
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.googleMaps)
    implementation(libs.material)
    implementation(libs.play.services.maps)
    // implementation(libs.splashScreen)
    implementation(libs.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}