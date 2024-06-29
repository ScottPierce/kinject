plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.gradleMavenPublish)
}

android {
    namespace = "kinject.viewmodel"
}

dependencies {
    api(project(":kinject"))
    implementation(libs.androidx.lifecycle.viewmodel.android)
}
