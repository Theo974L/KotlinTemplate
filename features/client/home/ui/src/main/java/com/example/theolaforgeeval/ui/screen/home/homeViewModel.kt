package com.example.theolaforgeeval.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent


class HomeViewModel() : ViewModel(), KoinComponent {
//    private val spaceRepository: SpaceRepository by inject()

    private var _uiState = MutableStateFlow(HomeUiState())
    val state: StateFlow<HomeUiState> = _uiState

    private var _uiEvents = Channel<HomeUiEvent>()
    val events: Flow<HomeUiEvent> = _uiEvents.receiveAsFlow()

    init {
        OnStart()
    }

    fun OnStart(){

    }

    fun onAction(action: HomeUiAction) {
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