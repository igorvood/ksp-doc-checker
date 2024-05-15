import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kspVersion: String by project
val kotlinpoet: String by project


plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":core"))

    implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")

    implementation("com.squareup:kotlinpoet:$kotlinpoet")
    implementation("com.squareup:kotlinpoet-ksp:$kotlinpoet")

}
repositories {
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val javaVersion: String by project
tasks.withType<KotlinCompile>{
    kotlinOptions{
        jvmTarget = javaVersion
    }
}
