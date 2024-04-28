package ru.vood.processor.finalcheck.properties

import kotlinx.serialization.Serializable

@Serializable
data class FilterProperty(
    val dataClasses: Boolean = false
)
