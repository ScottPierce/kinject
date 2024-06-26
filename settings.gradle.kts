pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "kinject"

include(":benchmark")
include(":benchmark-android")
include(":benchmark-shared")
include(":kinject")
include(":kinject-android")
include(":kinject-compose")
include(":kinject-viewmodel")
