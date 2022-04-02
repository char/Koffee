import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
    `maven-publish`
}

group = "codes.som.anthony"
version = "8.0.2"

repositories {
    mavenCentral()
}

dependencies {
    arrayOf("asm", "asm-tree", "asm-commons").forEach {
        implementation("org.ow2.asm:$it:9.2")
    }
}

kotlin {
    explicitApi()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

publishing {
    repositories {
        maven("$buildDir/repo")
    }

    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
        }
    }
}
