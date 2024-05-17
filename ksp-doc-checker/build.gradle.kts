val kspVersion: String by project
val junitJupiter: String by project
val kotlinCompileTesting: String by project
val ioMockk: String by project
val kotlinVersion: String by project
val kotlinxCoroutines: String by project
val kotlinpoet: String by project

plugins {
    kotlin("jvm")
    `maven-publish`
    kotlin("plugin.serialization")
//    id("maven-publish")
}

group = "ru.vood.ksp"
version = "1.0-SNAPSHOT"

dependencies {
    val kotestVersion = "5.6.2"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutines")
    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
    implementation("com.google.devtools.ksp:symbol-processing:$kspVersion")
    implementation("com.squareup:kotlinpoet:$kotlinpoet")
    implementation("com.squareup:kotlinpoet-ksp:$kotlinpoet")

    implementation("com.charleskorn.kaml:kaml:0.53.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.5.0")

    testImplementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:1.7.21!!")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiter")
    testImplementation("io.mockk:mockk:$ioMockk")
    testImplementation("com.github.tschuchortdev:kotlin-compile-testing:$kotlinCompileTesting")
    testImplementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-framework-datatest:$kotestVersion")

//    testImplementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:$kotlinVersion")

}
repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

kotlin {
//    sourceSets.main {
//        kotlin.srcDir("build/generated/ksp/main/kotlin")
//    }
    sourceSets.test {
        kotlin.srcDir("src/test/kotlin")
    }
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