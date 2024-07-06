plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.gradleMavenPublish)
}

kotlin {
    jvm()
    js()
    macosArm64()
    macosX64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    tvosX64()
    tvosArm64()
    tvosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        commonMain.dependencies {
            api(project(":kinject-core"))
            api(libs.kotlinx.coroutines.core)
        }
    }
}
