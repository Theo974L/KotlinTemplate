package com.example.theolaforgeeval.navhost

/**
 * Cette class permet de répertorier les routes dans le même endroit
 *
 * @see Screen sert a afficher les differentes pages de l'application
 *
 * @see Home la page d'accueil
 * @see Details la page de details
 *
 *
 */

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Details : Screen("details/{id}") {
        fun createRoute(id: Int) = "details/$id"
    }
}