package ru.vood.processor.finalcheck

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.Modifier
import ru.vood.processor.finalcheck.base.BaseSymbolProcessor
import java.io.File

class DocCheckProcessor(environment: SymbolProcessorEnvironment) : BaseSymbolProcessor(environment) {

    override fun processRound(resolver: Resolver): List<KSAnnotated> {
        // вычитка внешних настроек
        val file = File("/home/vood/IdeaProjects/ksp-doc-checker/testApp/DocCheckProcessor.yml.example")
        val createNewFile = file.createNewFile()
        file.writeText("Asdasdasd")
//        println(file.readText())

        return listOf()
    }

    private fun check(
        requiredModifiers: List<Modifier>,
        modifiers: Set<Modifier>,
        ksAnno: KSAnnotated,
        prohibitedModifiers: List<Modifier>,
        objectName: String
    ) {
        val notExistModifier = requiredModifiers.filter { modifier ->
            !modifiers.contains(modifier)
        }


        if (notExistModifier.isNotEmpty()) {
            kspLogger.error(
                "$objectName must contains Modifiers $notExistModifier. Current Modifiers are $modifiers",
                ksAnno
            )
        }

        val prohibitedModifier = prohibitedModifiers.filter { modifier ->
            modifiers.contains(modifier)
        }

        if (prohibitedModifier.isNotEmpty()) {
            kspLogger.error("$objectName contains prohibitedModifier Modifiers $prohibitedModifier", ksAnno)
        }
    }

    private fun <T> extractParam(paramValue: String?, extractor: (String) -> T): List<T> {

        return paramValue?.let {
            it
                .split(";")
                .map { param -> param.trim() }
                .filter { param -> param.isNotEmpty() }
                .map { paramStr -> extractor(paramStr) }
        } ?: listOf()
    }
}