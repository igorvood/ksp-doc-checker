package ru.vood.ksp.doccheck

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import ru.vood.ksp.doccheck.abstraction.AbstractKoraAppProcessorTest
import ru.vood.ksp.doccheck.abstraction.util.readFile

class DocCheckConfigProcessorProviderTest2: FunSpec({
    withData(
        TestCase("1", 1),
        TestCase("2", 2),)
    {
        val (description, numTest) = it
        class121.readFile("$numTest/SomeDataClass$numTest.kt")


        val abstractKoraAppProcessorTest: AbstractKoraAppProcessorTest = object :
            AbstractKoraAppProcessorTest(listOf(DocCheckConfigProcessorProvider()), listOf("SomeDataClass.kt")) {}


//        abstractKoraAppProcessorTest.beforeEach()

    }
}){
    companion object{
        val class121 = DocCheckConfigProcessorProviderTest2::class.java
    }
}