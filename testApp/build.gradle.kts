plugins {
    id("com.google.devtools.ksp")
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {

//    implementation(project(":final-check-processor"))
    ksp(project("::ksp-doc-checker"))
}

kotlin {
    sourceSets.main {
        kotlin.srcDirs(
            "src/main/kotlin",
            "build/generated/ksp/main/kotlin"
        )
    }
}