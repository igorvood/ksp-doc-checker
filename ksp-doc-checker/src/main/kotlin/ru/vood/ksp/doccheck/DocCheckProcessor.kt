package ru.vood.ksp.doccheck

import com.charleskorn.kaml.Yaml
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.impl.ResolverImpl
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.Modifier
import ru.vood.ksp.doccheck.base.BaseSymbolProcessor

import ru.vood.ksp.doccheck.properties.FilterName
import ru.vood.ksp.doccheck.properties.FilterProperties
import ru.vood.ksp.doccheck.properties.FilterProperty
import java.io.File

class DocCheckProcessor(environment: SymbolProcessorEnvironment) : BaseSymbolProcessor(environment) {

    override fun processRound(resolver: Resolver): List<KSAnnotated> {
        // вычитка внешних настроек
        val resolverImpl = resolver as ResolverImpl
        val propertyFileName = filenameResolver(resolverImpl, "DocCheckProcessor.yml")
        val exampleFileName = createExample(resolverImpl)
        try {

            val readText =
                File(propertyFileName).readText()
        } catch (e: Throwable) {
            kspLogger.error("Not Found $propertyFileName for example see $exampleFileName")
        }





        return listOf()
    }

    private fun createExample(resolverImpl: ResolverImpl): String {
        val propertyExampleFileName = "DocCheckProcessor.yml.example"
        val exampleFilenameResolver = filenameResolver(resolverImpl, propertyExampleFileName)
        val exampleFile = File(exampleFilenameResolver)
        exampleFile.createNewFile()
        val filterProperties = FilterProperties(
            mapOf(
                FilterName("firstFilter") to FilterProperty(),
                FilterName("secondFilter") to FilterProperty()
            )
        )
        val result = Yaml.default.encodeToString(FilterProperties.serializer(), filterProperties)
        exampleFile.writeText(result)
        return exampleFilenameResolver
    }

    private fun filenameResolver(resolverImpl: ResolverImpl, s: String) =
        resolverImpl.options.projectBaseDir.absolutePath + File.separator + s

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