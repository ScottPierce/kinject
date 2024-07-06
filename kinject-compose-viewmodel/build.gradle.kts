plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.gradleMavenPublish)
}

android {
    namespace = "kinject.compose.viewmodel"
}

dependencies {
    api(project(":kinject-compose"))
    api(project(":kinject-viewmodel"))
    api(libs.androidx.lifecycle.viewmodel.compose)
}
