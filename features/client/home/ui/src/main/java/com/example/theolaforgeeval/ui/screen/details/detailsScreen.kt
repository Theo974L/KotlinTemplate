package com.example.theolaforgeeval.ui.screen.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adamglin.PhosphorIcons
import com.adamglin.phosphoricons.Bold
import com.adamglin.phosphoricons.bold.ArrowElbowLeft
import com.example.theolaforgeeval.core.extensions.vibrate
import com.example.theolaforgeeval.core.ui.component.BottomNavigationBar
import com.example.theolaforgeeval.core.ui.component.QuickActionButton
import com.example.theolaforgeeval.features.client.home.ui.R

@Composable
fun DetailsScreen(viewModel: DetailsViewModel, id: Int, navController: NavController) {
    val uiState by viewModel.state.collectAsState()

    LaunchedEffect(id) {
//        viewModel.events.collect { event ->
//            when (event) {
//                is Logout -> onLogout()
//            }
//        }

        viewModel.OnStart(id)
    }

    Details(
        uiState,
        viewModel::onAction,
        navController
    )

}

@Composable
private fun Details(
    uiState: DetailsUiState,
    onAction: (DetailsUiAction) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) = Scaffold(
    modifier = modifier
        .fillMaxSize()
        .background(Color(11,23,48,1)),
        bottomBar = { BottomNavigationBar(navController) }
) {innerPadding ->
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        // --- Grid de cards ---
        Spacer(modifier = Modifier.height(16.dp))

        Text(stringResource(R.string.bienvenue) + uiState.id, color = Color.DarkGray, fontSize = TextUnit(24f, TextUnitType.Sp)
            , fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 16.dp)
        )

        QuickActionButton(
            label = stringResource(R.string.button_text2),
            onClick = { context.vibrate(); navController.navigate("home") },
            icon = PhosphorIcons.Bold.ArrowElbowLeft,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
