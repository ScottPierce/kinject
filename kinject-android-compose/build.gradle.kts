plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.gradleMavenPublish)
}

android {
    namespace = "kinject.android.compose"
}

dependencies {
    api(project(":kinject-android"))
    implementation(libs.androidx.activity.compose)
}
