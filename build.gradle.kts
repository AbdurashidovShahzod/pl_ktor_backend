//val ktor_version: String by project
//val kotlin_version: String by project
//val logback_version: String by project
//
//plugins {
//    application
//    kotlin("jvm") version "1.8.10"
//    id("io.ktor.plugin") version "2.2.3"
//    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
//}
//
//group = "com.example"
//version = "0.0.1"
//application {
//    mainClass.set("com.example.ApplicationKt")
//
//    val isDevelopment: Boolean = project.ext.has("development")
//    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
//}
//
//repositories {
//    mavenCentral()
//}
//
//dependencies {
//    implementation("io.ktor:ktor-server-conditional-headers-jvm:$ktor_version")
//    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
//    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
//    implementation ("io.ktor:ktor-server-core:$ktor_version")
//    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
//    implementation("io.ktor:ktor-server-core:$ktor_version")
//    implementation("ch.qos.logback:logback-classic:$logback_version")
//    implementation("io.ktor:ktor-serialization:$ktor_version")
//    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
//    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
//
//    implementation("io.ktor:ktor-serialization:$ktor_version")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
//
//
//
//
//
//}


val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project

plugins {
    application
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
    id("io.ktor.plugin") version "2.2.1"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}
ktor {
    fatJar {
        archiveFileName.set("fat.jar")
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-server-cio:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")

    implementation("org.postgresql:postgresql:42.5.1")
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation ("org.owasp:java-file-io:1.0.0")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.ow2.util.file:file:2.1.0")
    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

tasks.create("stage") {
    dependsOn("installDist")
}
