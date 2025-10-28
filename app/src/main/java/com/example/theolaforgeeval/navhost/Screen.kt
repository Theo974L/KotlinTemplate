package com.example.theolaforgeeval.navhost

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details/{id}") {
        fun createRoute(id: Int) = "details/$id"
    }
}