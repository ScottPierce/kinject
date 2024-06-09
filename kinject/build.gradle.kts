import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.gradleMavenPublish)
}

kotlin {
    jvm()
    js {
        browser()
        nodejs()
    }
    macosArm64()
    macosX64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    tvosX64()
    tvosArm64()
    tvosSimulatorArm64()

    sourceSets {
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

val ref = System.getenv()["GITHUB_REF"]
if (System.getenv()["GITHUB_REF_TYPE"] == "tag" && ref?.startsWith("refs/tags/v") == true) {
    val version = ref.removePrefix("refs/tags/v")
    println("Releasing Version: $version")

    mavenPublishing {
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)

        signAllPublications()

        coordinates(
            groupId = "dev.scottpierce",
            artifactId = "kinject",
            version = version,
        )

        pom {
            name.set("Kinject")
            description.set("A simple Kotlin Multiplatform dependency injection library.")
            inceptionYear.set("2024")
            url.set("https://github.com/ScottPierce/kinject")
            licenses {
                license {
                    name.set("The Apache License, Version 2.0")
                    url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                }
            }
            developers {
                developer {
                    id.set("ScottPierce")
                    name.set("Scott Pierce")
                    url.set("https://github.com/ScottPierce")
                }
            }
            scm {
                url.set("https://github.com/ScottPierce/kinject")
                connection.set("scm:git:git://github.com/ScottPierce/kinject.git")
                developerConnection.set("scm:git:ssh://git@github.com/ScottPierce/kinject.git")
            }
        }
    }
}
