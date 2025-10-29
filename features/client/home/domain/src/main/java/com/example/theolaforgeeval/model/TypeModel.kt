package com.example.theolaforgeeval.model

import kotlinx.serialization.Serializable

@Serializable
data class TypeDto(
    val name: String? = null,
    val image: String? = null
)
