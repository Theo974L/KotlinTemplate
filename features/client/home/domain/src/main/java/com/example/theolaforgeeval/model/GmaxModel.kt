package com.example.theolaforgeeval.model

import kotlinx.serialization.Serializable

@Serializable
data class GmaxDto(
    val regular: String? = null,
    val shiny: String? = null
)
