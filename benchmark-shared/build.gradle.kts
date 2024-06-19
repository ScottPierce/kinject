plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    macosArm64()
    js {
        nodejs()
    }

    sourceSets {
        commonMain.dependencies {
            api(project(":kinject"))
            api(libs.koin.core)
        }
    }
}
