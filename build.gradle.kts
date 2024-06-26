import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinTopLevelExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.gradleMavenPublish) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
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

val javaVersion = JavaVersion.VERSION_11
val javaVersionInt = javaVersion.ordinal + 1
val jvmTarget = JvmTarget.fromTarget(javaVersion.majorVersion)

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
}
