package com.example.theolaforgeeval.repository

import com.example.theolaforgeeval.model.PokemonDto
import com.example.theolaforgeeval.model.PokemonModel

interface PokemonRepository {
    suspend fun getPokemons() : List<PokemonModel>
    suspend fun getPokemonById(id: Int) : PokemonModel?
}
