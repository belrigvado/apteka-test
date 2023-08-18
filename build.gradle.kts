plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.11.0")
    testImplementation("org.seleniumhq.selenium:selenium-api:4.11.0")
    testImplementation("org.seleniumhq.selenium:selenium-http-jdk-client:4.11.0")
}

tasks.test {
    useJUnitPlatform()
}