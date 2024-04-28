val kspVersion: String by project
val junitJupiter: String by project
val kotlinCompileTesting: String by project
val ioMockk: String by project
val kotlinVersion: String by project

plugins {
    kotlin("jvm")
    `maven-publish`
    kotlin("plugin.serialization") version "1.7.21"
//    id("maven-publish")
}

group = "ru.vood.ksp"
version = "1.0-SNAPSHOT"

dependencies {
//    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
//    implementation(kotlin("stdlib"))
//    implementation("com.squareup:kotlinpoet:1.12.0")
//    implementation("com.squareup:kotlinpoet-ksp:1.12.0")



    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
    implementation("com.google.devtools.ksp:symbol-processing:$kspVersion")
    implementation("com.squareup:kotlinpoet:1.12.0")

    implementation("com.squareup:kotlinpoet-ksp:1.12.0")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    implementation("com.charleskorn.kaml:kaml:0.52.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.5.0")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiter")
    testImplementation("io.mockk:mockk:$ioMockk")
    testImplementation("com.github.tschuchortdev:kotlin-compile-testing:$kotlinCompileTesting")
    testImplementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:$kotlinVersion")

}
repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}


publishing{
    publications{
        create<MavenPublication>("maven") {
            groupId = "ru.vood.ksp"
            artifactId = "ksp-doc-checker"
            version = "1.1"

            from(components["java"])
        }
    }
}
//publishing {
//    publications {
//        maven(MavenPublication) {
//            groupId 'org.gradle.sample'
//            artifactId 'project1-sample'
//            version '1.1'
//            from components.java
//        }
//    }
//}