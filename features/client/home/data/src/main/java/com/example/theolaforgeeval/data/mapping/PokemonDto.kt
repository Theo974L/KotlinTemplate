package com.example.theolaforgeeval.data.mapping

import com.example.theolaforgeeval.model.PokemonModel

fun PokemonDto.toPokemon(): PokemonModel {
    return PokemonModel(id = this.id, name = this.name)
}