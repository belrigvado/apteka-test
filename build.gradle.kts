import org.gradle.internal.impldep.org.junit.platform.launcher.TagFilter

plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}
apply(plugin = "io.qameta.allure")

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("io.qameta.allure.gradle.allure:allure-plugin:2.11.2")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.11.0")
    testImplementation("org.seleniumhq.selenium:selenium-api:4.11.0")
    testImplementation("org.seleniumhq.selenium:selenium-http-jdk-client:4.11.0")
}


tasks.test {
    filter {
        excludeTestsMatching("org.example.*")
        isFailOnNoMatchingTests = false
    }
    useJUnitPlatform()
}