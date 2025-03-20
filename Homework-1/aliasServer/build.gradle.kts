group = rootProject.group
version = rootProject.version

plugins {
    id("org.springframework.boot") version "3.0.0" // Replace with your desired Spring Boot version
    id("io.spring.dependency-management") version "1.1.0" // Dependency management plugin
    kotlin("jvm") version "1.8.20" // Kotlin plugin
    kotlin("plugin.spring") version "1.8.20" // Kotlin Spring plugin
}

repositories {
    mavenCentral() // Central Maven repository
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter") // Core Spring Boot starter
    implementation("org.springframework.boot:spring-boot-starter-web") // Web starter for Spring Boot
    implementation("org.jetbrains.kotlin:kotlin-reflect") // Kotlin reflection
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") // Kotlin standard library
    testImplementation("org.springframework.boot:spring-boot-starter-test") // For testing with Spring Boot
}
