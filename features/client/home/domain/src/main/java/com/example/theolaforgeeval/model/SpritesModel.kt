package com.example.theolaforgeeval.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpritesDto(
    val regular: String? = null,
    val shiny: String? = null,
    @SerialName("gmax") val gMax: GMaxDto? = null
)