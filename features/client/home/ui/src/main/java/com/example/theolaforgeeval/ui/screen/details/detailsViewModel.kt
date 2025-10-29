package com.example.theolaforgeeval.ui.screen.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theolaforgeeval.repository.PokemonRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class DetailsViewModel() : ViewModel(), KoinComponent {
    private val pokemonRepository: PokemonRepository by inject()

    private var _uiState = MutableStateFlow(DetailsUiState())
    val state: StateFlow<DetailsUiState> = _uiState

    private var _uiEvents = Channel<DetailsUiEvent>()
    val events: Flow<DetailsUiEvent> = _uiEvents.receiveAsFlow()

    fun onStart(id: Int) {
        _uiState.update { it.copy(id = id) }

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                val pokemon = pokemonRepository.getPokemonById(id = _uiState.value.id) // récupère tous les Pokémon

                Log.d("DetailsViewModel", "Pokemon reçu: $pokemon")

                _uiState.value = _uiState.value.copy(
                    pokemon = pokemon,
                    isLoading = false,
                    error = null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Erreur inconnue"
                )
                _uiEvents.send(Error("Les données ont pas pu être récupérées"))
            }
        }
    }

    fun onAction(action: DetailsUiAction) {
        when (action) {
            ClickedOnBack -> {
                viewModelScope.launch {
                    _uiEvents.send(Back())
                }
            }

//            is TypedPassword -> onPasswordChange(action.password)
//            ClickedOnLogin -> onLoginClicked()
        }
    }
}