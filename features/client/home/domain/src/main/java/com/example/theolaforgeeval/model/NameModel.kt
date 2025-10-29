package com.example.theolaforgeeval.model

import kotlinx.serialization.Serializable

@Serializable
data class NameDto(
    val fr: String? = null,
    val en: String? = null,
    val jp: String? = null
)