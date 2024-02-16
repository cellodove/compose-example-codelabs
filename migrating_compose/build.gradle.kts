plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.cellodove.migrating_compose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cellodove.migrating_compose"
        minSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        dataBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))

    kapt ("androidx.room:room-compiler:2.6.1")
    kapt("com.github.bumptech.glide:compiler:4.16.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("androidx.room:room-runtime:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("androidx.work:work-runtime-ktx:2.9.0")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.google.android.material:material:1.11.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

    // Compose
//    implementation ("androidx.compose.runtime:runtime")
//    implementation ("androidx.compose.ui:ui")
//    implementation ("androidx.compose.foundation:foundation")
//    implementation ("androidx.compose.foundation:foundation-layout")
//    implementation ("androidx.compose.material:material")
//    implementation ("androidx.compose.runtime:runtime-livedata")
//    implementation ("androidx.compose.ui:ui-tooling-preview")
//    debugImplementation ("androidx.compose.ui:ui-tooling")

    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3:1.2.0")
    implementation("androidx.compose.material3:material3-window-size-class:1.2.0")

    // Testing dependencies
    androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation ("androidx.test.espresso:espresso-contrib:3.5.1")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.test.espresso:espresso-intents:3.5.1")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.uiautomator:uiautomator:2.2.0")
    androidTestImplementation ("androidx.work:work-testing:2.9.0")
    androidTestImplementation ("com.google.android.apps.common.testing.accessibility.framework:accessibility-test-framework:4.1.0")
    androidTestImplementation ("com.google.truth:truth:1.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4")
    testImplementation ("junit:junit:4.13.2")


}