package com.example.theolaforgeeval.ui.screen.home

import com.example.theolaforgeeval.model.PokemonModel

/*
*
*
* */


data class HomeUiState(
    val namePokemon: String = "",
    val pokemonList: List<PokemonModel> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null,
)


sealed interface HomeUiAction
    data class TypedNamePokemon(val namePokemon : String) : HomeUiAction
    data object ClickedOnSearch : HomeUiAction


sealed interface HomeUiEvent
    data class Error(val message: String) :  HomeUiEvent

