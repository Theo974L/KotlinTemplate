package com.example.theolaforgeeval.ui.screen.details

data class DetailsUiState(
    val id: Int = 0,
    val isLoading: Boolean = false,
    val error: String? = null,
)

sealed interface DetailsUiAction
data object ClickedOnLogout : DetailsUiAction

sealed interface DetailsUiEvent
class Logout() : DetailsUiEvent