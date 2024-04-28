package ru.vood.processor.finalcheck.properties

import kotlinx.serialization.Serializable

@Serializable
data class FilterProperties(
    val filters: Map<FilterName, FilterProperty>
)


