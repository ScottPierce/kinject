plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    macosArm64()
    js {
        nodejs()
    }

    sourceSets {
        commonMain.dependencies {
            api(project(":kinject-core"))
            api(libs.koin.core)
        }
    }
}
