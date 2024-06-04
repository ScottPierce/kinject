plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.allOpen)
    alias(libs.plugins.kotlinx.benchmark)
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(project(":kinject"))
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
    }
}
