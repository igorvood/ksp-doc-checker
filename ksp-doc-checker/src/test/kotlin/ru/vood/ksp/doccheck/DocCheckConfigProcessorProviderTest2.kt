package ru.vood.ksp.doccheck

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
class DocCheckConfigProcessorProviderTest2: FunSpec({
    withData(
        TestCase("1", 1),
        TestCase("2", 2),)
    {

    }
}){
    companion object{
        val class121 = DocCheckConfigProcessorProviderTest2::class.java
    }
}