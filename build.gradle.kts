buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    // Java support
    id("java")
    // Kotlin support
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    // Gradle IntelliJ Plugin
    id("org.jetbrains.intellij") version "1.13.2"
    // Gradle Changelog Plugin
//    id("org.jetbrains.changelog") version "2.0.0"
    // Gradle Qodana Plugin
//    id("org.jetbrains.qodana") version "0.1.13"
    // Gradle Kover Plugin
//    id("org.jetbrains.kotlinx.kover") version "0.6.1"
}


repositories {
    mavenCentral()
}

group = "io.github.mishkun"
version = "1.1.2"

kotlin {
    jvmToolchain(17)
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2023.1")
}

tasks.getByName<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    changeNotes.set("""
        Parse config file on startup to speedup action popup
    """.trimIndent())
    sinceBuild.set("231")
    untilBuild.set("")
}

dependencies {
    implementation("com.typesafe:config:1.4.1")
}
