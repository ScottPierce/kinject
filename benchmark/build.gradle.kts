plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.allOpen)
    alias(libs.plugins.kotlinx.benchmark)
}

kotlin {
    jvm()
    macosArm64()
    js {
        nodejs()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":benchmark-shared"))
            implementation(libs.kotlinx.benchmark)
        }
    }
}

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}

benchmark {
    targets {
        register("jvm")
        register("macosArm64")
        register("js")
    }
}
