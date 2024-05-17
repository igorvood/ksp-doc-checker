package ru.vood.ksp.doccheck

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import ru.vood.ksp.doccheck.DocCheckProcessor.Companion.propFilePath
import ru.vood.ksp.doccheck.abstraction.AbstractDocCheckerProcessorTest
import ru.vood.ksp.doccheck.abstraction.AbstractKoraAppProcessorTest
import ru.vood.ksp.doccheck.abstraction.util.copyFile
import ru.vood.ksp.doccheck.abstraction.util.readFile

//@Disabled
class DocCheckConfigProcessorProviderTest:
    AbstractDocCheckerProcessorTest(
        listOf(DocCheckConfigProcessorProvider()),
        listOf("SomeDataClass.kt")
    ) {


    @Test
    fun create() {
      kotlin.runCatching { compile(mapOf(propFilePath to "kspsssssss/DocCheckProcessor.yml")) }
          .map { error("test must fail ") }

        val messages = compileResult.messages
//        Assertions.assertEquals(listOf<String>(), messages)

    }
}