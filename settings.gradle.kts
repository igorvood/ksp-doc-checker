// как настраивать версии в грейдл для мульти модульных проектов https://docs.gradle.org/current/userguide/platforms.html

//плугин с кодо генерацией https://habr.com/ru/companies/yota/articles/565440/
//Kotlin Symbol Processing. От теории до практики https://habr.com/ru/companies/cian/articles/705278/
// пример генератора от тинькова https://github.com/Tinkoff/kora?ysclid=ltojwtlwp7423328427
//вроде оф сайт kotlin poet https://square.github.io/kotlinpoet/
// в их гит хабе есть дока, на самом сайте ей маловато
// https://github.com/square/kotlinpoet/tree/main/docs

pluginManagement {
    val kotlinVersion: String by settings
    val kspVersion: String by settings
    val kotlinSerialization: String by settings

    plugins {
        id("com.google.devtools.ksp") version kspVersion
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.serialization") version kotlinSerialization
    }

    repositories {
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
}


include(":ksp-doc-checker")
include(":testApp")
//include(":symbol-processor-common")
//include(":workload")



