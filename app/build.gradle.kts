plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.cmsc436groupproject"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cmsc436groupproject"
        minSdk = 24
        targetSdk = 35
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation("androidx.recyclerview:recyclerview:1.3.1")


    implementation("com.google.android.gms:play-services-ads:23.5.0")

    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))

    // Add the Firebase Analytics dependency
    implementation("com.google.firebase:firebase-analytics")

    // Add other Firebase dependencies here as needed
    // Example: Realtime Database
    implementation("com.google.firebase:firebase-database")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
