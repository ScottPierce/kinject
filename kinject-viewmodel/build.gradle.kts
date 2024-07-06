plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.gradleMavenPublish)
}

kotlin {
    jvm()
    androidTarget()
    macosArm64()
    macosX64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            api(project(":kinject-core"))
            implementation(libs.androidx.lifecycle.viewmodel)
        }
    }
}

android {
    namespace = "kinject.viewmodel"
}
