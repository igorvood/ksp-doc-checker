package ru.vood.model.generator.ksp.common.util

import com.squareup.kotlinpoet.ClassName

fun ClassName.import() = "import ${this.canonicalName}"