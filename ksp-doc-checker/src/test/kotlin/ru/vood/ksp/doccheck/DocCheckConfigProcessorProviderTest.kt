package ru.vood.ksp.doccheck

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import ru.vood.ksp.doccheck.abstraction.AbstractKoraAppProcessorTest

@Disabled
class DocCheckConfigProcessorProviderTest:
    AbstractKoraAppProcessorTest(
        listOf(DocCheckConfigProcessorProvider()),
        listOf("SomeDataClass.kt")
    ) {

    @Test
    fun create() {
        compile()
    }
}