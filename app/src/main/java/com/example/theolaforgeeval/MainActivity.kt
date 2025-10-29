package com.example.theolaforgeeval

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.theolaforgeeval.navhost.AppNavHost
import com.example.theolaforgeeval.core.ui.theme.TheoLaforgeEvalTheme
import com.example.theolaforgeeval.core.ui.utils.enableFullScreenMode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        enableFullScreenMode()

        setContent {
            TheoLaforgeEvalTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)


            }
        }
    }


    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "App mise en pause")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "App est detruite")

    }
}