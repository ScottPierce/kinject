plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.gradleMavenPublish)
}

android {
    namespace = "kinject.compose.voyager"
}

dependencies {
    api(project(":kinject-compose"))
    implementation(libs.voyager.core)
    implementation(libs.voyager.navigator)
    implementation(libs.voyager.screenModel)
}
