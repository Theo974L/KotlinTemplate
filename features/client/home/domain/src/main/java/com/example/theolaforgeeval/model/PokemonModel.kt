package com.example.theolaforgeeval.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.*

@Entity(tableName = "pokemon")
data class PokemonModel(
    @PrimaryKey val id: Int,
    val name: String,
    val sprite: String?,
    val types: List<String>
)


@Serializable
data class PokemonDto(
    @SerialName("pokedex_id") val id: Int,
    val generation: Int? = null,
    val category: String? = null,
    val name: NameDto,
    val sprites: SpritesDto? = null,
    val types: List<TypeDto>? = null,
    val height: String? = null,
    val weight: String? = null
)



