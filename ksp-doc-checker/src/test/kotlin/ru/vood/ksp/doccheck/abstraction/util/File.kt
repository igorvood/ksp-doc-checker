package ru.vood.ksp.doccheck.abstraction.util

import java.io.File
import java.util.*

private val pathSeparator = "/"

fun readFromFile(javaClass: Class<*>, fileName: String): String {
    val replace = javaClass.name.replace(".", pathSeparator)
    val s = replace + pathSeparator + fileName
    val orElseGet = Optional.ofNullable(javaClass.classLoader.getResource(s))
        .map { File(it.path) }
        .orElseGet { error("Unable to read file $s") }

    return orElseGet.bufferedReader().readLines().joinToString("\n")

}

fun Class<*>.readFile(fileName: String) = readFromFile(this, fileName)