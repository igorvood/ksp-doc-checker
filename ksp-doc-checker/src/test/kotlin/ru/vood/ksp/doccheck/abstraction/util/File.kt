package ru.vood.ksp.doccheck.abstraction.util

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.*

private val pathSeparator = "/"

fun readFromFile(javaClass: Class<*>, fileName: String): String {
    val path: String = getPathByFile(javaClass, fileName)
    val orElseGet = Optional.ofNullable(javaClass.classLoader.getResource(path))
        .map { File(it.path) }
        .orElseGet { error("Unable to read file $path") }

    return orElseGet.bufferedReader().readLines().joinToString("\n")

}

private fun getPathByFile(javaClass: Class<*>, fileName: String): String {
    val replace = javaClass.name.replace(".", pathSeparator)
    val path: String = replace + pathSeparator + fileName
    return path
}

fun Class<*>.readFile(fileName: String) = readFromFile(this, fileName)


fun Class<*>.copyFile(fileName: String, destinationFilePath: String) : File {
    val file = File(destinationFilePath)
     file.printWriter().use { out ->
        out.println(readFile(fileName))
    }
    return file

//    val sourceFilePath = getPathByFile(this, fileName)
//    val source = Path.of(sourceFilePath)
//    val destination = Path.of(destinationFilePath)

    // Use Files.copy to copy the file
//    Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING)
}