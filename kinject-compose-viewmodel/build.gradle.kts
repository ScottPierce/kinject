plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.gradleMavenPublish)
}

android {
    namespace = "kinject.viewmodel.compose"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    testBuildType = "release"
    buildTypes {
        debug {
        }
        release {
            isDefault = true
        }
    }
}

dependencies {
    api(project(":kinject-android"))
    api(project(":kinject-compose"))
    api(project(":kinject-viewmodel"))
    implementation(libs.androidx.lifecycle.viewmodel.compose)
}
