plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.ksik.myeduapplication"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"


        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(lib.androidx.core.ktx)
    implementation(lib.androidx.appcompat)
    implementation(lib.google.material)
    implementation(lib.androidx.constraintlayout)
    implementation(lib.test.junit.junit)
    implementation(lib.test.ext.junit)
    implementation(lib.test.ext.espresso.core)
}