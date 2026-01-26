import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.3.0"
    kotlin("plugin.serialization") version "2.3.0"
    id("com.gradleup.shadow") version "8.3.0"
}

group = "kim.present.pnx.template"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.opencollab.dev/maven-releases/")
    maven("https://repo.opencollab.dev/maven-snapshots/")
    maven("https://repo.powernukkitx.org/releases")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("org.powernukkitx:server:2.0.0-SNAPSHOT")
    compileOnly(kotlin("stdlib"))
    compileOnly("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
    compileOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_21
    }
}

tasks.jar {
    enabled = true
    archiveClassifier.set("dev")
}

tasks.withType<ShadowJar> {
    archiveClassifier.set("")
    minimize()
}
