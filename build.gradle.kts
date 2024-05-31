plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
}

apply(rootProject.file("gradle/ktlint.gradle.kts"))

subprojects {
    group = "dev.scottpierce"
    version = "1.0.0"
}
