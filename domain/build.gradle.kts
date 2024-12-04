plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

dependencies {
    //region Coroutine
    implementation(libs.kotlinx.coroutines.core.v164)
    implementation(libs.kotlinx.coroutines.android)
    //endregion

    implementation(libs.javax.inject)
}