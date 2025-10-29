package com.example.theolaforgeeval.ui.screen.details

import com.example.theolaforgeeval.model.PokemonModel
import com.example.theolaforgeeval.ui.screen.home.HomeUiEvent

data class DetailsUiState(
    val id: Int = 0,
    val pokemon: PokemonModel? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)

sealed interface DetailsUiAction
data object ClickedOnBack : DetailsUiAction

sealed interface DetailsUiEvent
    data class Error(val message: String) : DetailsUiEvent
    class Back() : DetailsUiEvent