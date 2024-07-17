plugins {
    `java-platform`
    alias(libs.plugins.gradleMavenPublish)
}

javaPlatform {
    allowDependencies()
}

dependencies {
    constraints {
        api(project(":kinject-core"))
        api(project(":kinject-android"))
        api(project(":kinject-android-appcompat"))
        api(project(":kinject-android-compose"))
        api(project(":kinject-compose"))
        api(project(":kinject-compose-viewmodel"))
        api(project(":kinject-compose-voyager"))
        api(project(":kinject-coroutines"))
        api(project(":kinject-viewmodel"))
    }
}
