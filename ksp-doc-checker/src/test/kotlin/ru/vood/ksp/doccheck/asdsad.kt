package ru.vood.ksp.doccheck

import io.kotest.datatest.WithDataTestName

data class TestCase(
    val description: String ="ASdasd",
//    val mutation: IMutation,
//    val expected: IExpected,
) : WithDataTestName {
    override fun dataTestName(): String = description
}
