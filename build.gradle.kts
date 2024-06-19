plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.gradleMavenPublish) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.androidx.benchmark) apply false
}

apply(rootProject.file("gradle/ktlint.gradle.kts"))

subprojects {
    group = "dev.scottpierce"
    version = "0.1.0"
}
