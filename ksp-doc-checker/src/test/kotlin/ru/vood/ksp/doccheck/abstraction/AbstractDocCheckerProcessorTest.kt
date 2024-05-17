package ru.vood.ksp.doccheck.abstraction

import com.google.devtools.ksp.processing.SymbolProcessorProvider
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import ru.vood.ksp.doccheck.abstraction.util.copyFile
import java.io.File

abstract class AbstractDocCheckerProcessorTest(
    symbolProcessors: List<SymbolProcessorProvider>,
    sourceList: List<String> = listOf(),
):  AbstractKoraAppProcessorTest(
symbolProcessors, sourceList
) {

    @BeforeEach
    fun beforeEach(){

        val copyFile = this::class.java.copyFile(
            "DocCheckProcessor.yml",
            destinationFilePath
        )
    }

    @AfterEach
    fun afterEacha(){
        File(destinationFilePath).delete()
    }

    companion object{
        val destinationFilePath = "build/in-test-generated-ksp/ksp/DocCheckProcessor.yml"
    }
}