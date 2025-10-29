package com.example.theolaforgeeval.data.mapping


import com.example.theolaforgeeval.model.PokemonDto
import com.example.theolaforgeeval.model.PokemonModel


fun PokemonDto.toPokemonModel(): PokemonModel {
    return PokemonModel(
        id = id,
        name = name.fr ?: name.en ?: "Unknown",
        sprite = sprites?.regular,
        types = types?.map { it.name ?: "Unknown" } ?: emptyList()
    )
}
