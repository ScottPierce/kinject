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

include(":benchmark:benchmark-android")
include(":benchmark:benchmark-kotlin")
include(":benchmark:benchmark-shared")
include(":kinject-android")
include(":kinject-bom")
include(":kinject-compose")
include(":kinject-compose-viewmodel")
include(":kinject-core")
include(":kinject-viewmodel")
include(":sample:kinject-sample-android")
