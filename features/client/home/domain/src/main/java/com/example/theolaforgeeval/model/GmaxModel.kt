package com.example.theolaforgeeval.model

import kotlinx.serialization.Serializable

@Serializable
data class GMaxDto(
    val regular: String? = null,
    val shiny: String? = null
)
