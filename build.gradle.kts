import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinTopLevelExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.gradleMavenPublish) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.androidx.benchmark) apply false
}

apply(rootProject.file("gradle/ktlint.gradle.kts"))

object AndroidConfig {
    const val compileSdkVersion = 34
    const val targetSdkVersion = 34
    const val minSdkVersion = 23
    const val composeCompilerVersion = "1.5.14"
}

val javaVersion = JavaVersion.VERSION_1_8
val javaVersionInt = javaVersion.ordinal + 1
val jvmTarget = JvmTarget.JVM_1_8

subprojects {
    group = "dev.scottpierce"
    version = "0.1.0"

    plugins.withId("com.android.application") {
        configure<ApplicationExtension> {
            compileOptions {
                sourceCompatibility = javaVersion
                targetCompatibility = javaVersion
            }

            compileSdk = AndroidConfig.compileSdkVersion

            defaultConfig {
                minSdk = AndroidConfig.minSdkVersion
                targetSdk = AndroidConfig.targetSdkVersion
            }
        }
    }

    plugins.withId("com.android.library") {
        configure<LibraryExtension> {
            compileOptions {
                sourceCompatibility = javaVersion
                targetCompatibility = javaVersion
            }

            compileSdk = AndroidConfig.compileSdkVersion

            defaultConfig {
                minSdk = AndroidConfig.minSdkVersion
            }
        }
    }

    plugins.withId("com.android.test") {
        configure<TestExtension> {
            compileOptions {
                sourceCompatibility = javaVersion
                targetCompatibility = javaVersion
            }

            compileSdk = AndroidConfig.compileSdkVersion

            defaultConfig {
                minSdk = AndroidConfig.minSdkVersion
                targetSdk = AndroidConfig.targetSdkVersion
            }
        }
    }

    tasks.withType<KotlinCompile> {
        compilerOptions.jvmTarget.set(jvmTarget)
    }

    plugins.withId("org.jetbrains.kotlin.jvm") {
        configure<KotlinTopLevelExtension> {
            jvmToolchain(javaVersionInt)
        }
    }

    val ref = System.getenv()["GITHUB_REF"]
    if (System.getenv()["GITHUB_REF_TYPE"] == "tag" && ref?.startsWith("refs/tags/v") == true) {
        val version = ref.removePrefix("refs/tags/v")
        println("Releasing Version: $version")

        plugins.withId(libs.plugins.gradleMavenPublish.get().pluginId) {
            configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
                publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)

                signAllPublications()

                coordinates(
                    groupId = "dev.scottpierce",
                    artifactId = project.name,
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
    }
}
