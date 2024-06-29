import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.gradleMavenPublish)
}

kotlin {
    jvm()
    js {
        browser()
        nodejs()
    }
    macosArm64()
    macosX64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    tvosX64()
    tvosArm64()
    tvosSimulatorArm64()

    sourceSets {
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
