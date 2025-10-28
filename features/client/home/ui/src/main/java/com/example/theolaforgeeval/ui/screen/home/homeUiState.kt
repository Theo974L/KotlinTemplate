package com.example.theolaforgeeval.ui.screen.home

/*
*
*
* */


data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
)


sealed interface HomeUiAction
    data object ClickedOnLogout : HomeUiAction

sealed interface HomeUiEvent
    class Logout() : HomeUiEvent

