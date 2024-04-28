package ru.vood.processor.finalcheck.properties

import kotlinx.serialization.Serializable

@Serializable
data class FilterProperty(
//    val filterName: FilterName,
    val dataClasses: Boolean = false
)
