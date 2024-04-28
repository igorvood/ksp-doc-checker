package ru.vood.ksp.doccheck.properties

import kotlinx.serialization.Serializable

@Serializable
data class FilterProperties(
    val filters: Map<FilterName, FilterProperty>
)


