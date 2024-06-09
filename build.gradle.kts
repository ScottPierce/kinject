plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.gradleMavenPublish) apply false
}

apply(rootProject.file("gradle/ktlint.gradle.kts"))

subprojects {
    group = "dev.scottpierce"
    version = "0.1.0"
}
