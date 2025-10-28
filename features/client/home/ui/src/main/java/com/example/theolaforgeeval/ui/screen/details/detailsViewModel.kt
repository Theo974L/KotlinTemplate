package com.example.theolaforgeeval.ui.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent


class DetailsViewModel() : ViewModel(), KoinComponent {
//    private val spaceRepository: SpaceRepository by inject()

    private var _uiState = MutableStateFlow(DetailsUiState())
    val state: StateFlow<DetailsUiState> = _uiState

    private var _uiEvents = Channel<DetailsUiEvent>()
    val events: Flow<DetailsUiEvent> = _uiEvents.receiveAsFlow()


    fun OnStart(id: Int){
        _uiState.update { it.copy(id = id) }
    }

    fun onAction(action: DetailsUiAction) {
        when (action) {
            ClickedOnLogout -> {
                viewModelScope.launch {

                }
            }

//            is TypedPassword -> onPasswordChange(action.password)
//            ClickedOnLogin -> onLoginClicked()
        }
    }
}