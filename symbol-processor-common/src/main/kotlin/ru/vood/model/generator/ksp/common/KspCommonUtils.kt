package ru.vood.model.generator.ksp.common

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.TypeSpec
import kotlin.reflect.KClass

object KspCommonUtils {

    fun TypeSpec.Builder.generated(generator: KClass<*>) = addAnnotation(
        AnnotationSpec.builder(CommonClassNames.generated)
            .addMember("value = [%S]", generator.java.canonicalName)
//            .addMember("date = %S", Instant.now())
            .build()
    )
}