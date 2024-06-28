plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.gradleMavenPublish)
}

android {
    namespace = "kinject.android"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
}

dependencies {
    api(project(":kinject"))
    implementation(libs.androidx.lifecycle.viewmodel.android)
}
