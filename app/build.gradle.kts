// 1. Plugins: Áp dụng plugin vào module này để biến nó thành Android App
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.detekt)
}

// 2. Android Block: Cấu hình biên dịch Android
android {
    namespace = "com.example.cryptotracker"
    // compileSdk: Version Android SDK dùng để biên dịch code (nên để mới nhất, VD: 36)
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.example.cryptotracker" // ID ứng dụng trên Store
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk // App tối ưu tốt nhất cho Android 16
        versionCode = Versions.versionCode
        versionName = Versions.versionName

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

    // compileOptions: Cấu hình Java version (Bắt buộc để dùng thư viện mới)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // kotlinOptions: Cấu hình riêng cho Kotlin
    kotlin {
        compilerOptions {
            optIn.add("kotlin.RequiresOptIn")
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {
    // Core
    implementation(libs.androidx.core.ktx)

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    debugImplementation(libs.androidx.ui.tooling)

    // XML UI
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Hilt (DI)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Network
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    // Database (Room)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
}