package com.example.theolaforgeeval.navhost

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.theolaforgeeval.ui.screen.home.HomeScreen
import com.example.theolaforgeeval.ui.screen.details.DetailsScreen
import com.example.theolaforgeeval.ui.screen.details.DetailsViewModel
import com.example.theolaforgeeval.ui.screen.home.HomeViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {

        /**
         *
         * @see Composable ça sert a afficher les differentes pages de l'application
         *
         *
         */


        composable(
            route = Screen.Home.route
        ) {
            val viewModel = viewModel { HomeViewModel() }
            HomeScreen(
                viewModel = viewModel,
                onNavigateDetails = { id ->
                    navController.navigate(Screen.Details.createRoute(id)) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                },
                navController
            )
        }

        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments!!.getInt("id")
            val vm = viewModel { DetailsViewModel() }
            DetailsScreen(
                vm,
                id = id,
                navController = navController
            )
        }
    }
}