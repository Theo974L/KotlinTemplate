package com.example.theolaforgeeval.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theolaforgeeval.repository.PokemonRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class HomeViewModel() : ViewModel(), KoinComponent {
    private val pokemonRepository: PokemonRepository by inject()

    private var _uiState = MutableStateFlow(HomeUiState())
    val state: StateFlow<HomeUiState> = _uiState

    private var _uiEvents = Channel<HomeUiEvent>()
    val events: Flow<HomeUiEvent> = _uiEvents.receiveAsFlow()

    init {
        onStart()
    }

    fun onStart() {
        viewModelScope.launch {
            try {
                val allPokemons = pokemonRepository.getPokemons() // récupère tous les Pokémon
                val firstTwenty = allPokemons.take(20) // garde seulement les 20 premiers

                _uiState.value = _uiState.value.copy(
                    pokemonList = firstTwenty,
                    error = null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Erreur inconnue"
                )
                _uiEvents.send(Error("Les données ont pas pu être récupérées"))
            } finally {
                _uiState.value = _uiState.value.copy( isLoading = false )
            }
        }
    }

    fun onAction(action: HomeUiAction) {
        when (action) {
            is TypedNamePokemon -> { onNamePokemonChange(action.namePokemon) }
            is ClickedOnSearch -> { onSearchClicked() }
        }
    }

    private fun onNamePokemonChange(namePokemon: String) {
        _uiState.value = _uiState.value.copy(namePokemon = namePokemon)
    }

    private fun onSearchClicked(){

        viewModelScope.launch {
            if(_uiState.value.namePokemon.isNotEmpty()) {
                /* TODO Feature trop peu importante
                *
                * Seulement la logique est a mettre ici
                *
                * */
            }
        }
    }



}