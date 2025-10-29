package com.example.theolaforgeeval.repository

import com.example.theolaforgeeval.model.PokemonModel

// Pour l'injection de dependance
interface PokemonRepository {
    suspend fun getPokemons() : List<PokemonModel>
    suspend fun getPokemonById(id: Int) : PokemonModel?
}
