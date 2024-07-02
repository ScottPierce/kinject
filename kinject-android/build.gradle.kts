plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.gradleMavenPublish)
}

android {
    namespace = "kinject.android"
}

dependencies {
    api(project(":kinject-core"))
    implementation(libs.androidx.lifecycle.viewmodel.android)
}
