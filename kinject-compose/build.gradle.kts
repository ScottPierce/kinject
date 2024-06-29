import org.gradle.kotlin.dsl.support.kotlinCompilerOptions

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.gradleMavenPublish)
}

android {
    namespace = "kinject.compose"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

composeCompiler {
    stabilityConfigurationFile = project.layout.projectDirectory.file("compose-stability-config.conf")
}

dependencies {
    implementation(project(":kinject"))
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.runtime)
}