package com.example.spacebooking.login.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adamglin.PhosphorIcons
import com.adamglin.phosphoricons.Bold
import com.adamglin.phosphoricons.bold.ArrowElbowLeft
import com.example.theolaforgeeval.core.extensions.playSound
import com.example.theolaforgeeval.core.extensions.vibrate
import com.example.theolaforgeeval.core.ui.component.BottomNavigationBar
import com.example.theolaforgeeval.core.ui.component.QuickActionButton
import com.example.theolaforgeeval.features.client.home.ui.R
import com.example.theolaforgeeval.ui.screen.home.HomeUiAction
import com.example.theolaforgeeval.ui.screen.home.HomeUiState
import com.example.theolaforgeeval.ui.screen.home.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel, OnNavigateDetails: (Int) -> Unit, navController: NavController) {
    val uiState by viewModel.state.collectAsState()

//    LaunchedEffect(viewModel) {
//        viewModel.events.collect { event ->
//            when (event) {
//                is Logout -> onLogout()
//            }
//        }
//    }

    Home(uiState, viewModel::onAction, OnNavigateDetails, navController)

}

@Composable
private fun Home(
    uiState: HomeUiState,
    onAction: (HomeUiAction) -> Unit,
    OnNavigateDetails: (Int) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = stringResource(R.string.bienvenue),
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = stringResource(R.string.desc),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                        )
                    )
                }
            }

            Text(
                text = stringResource(R.string.titre),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                )
            )

            QuickActionButton(
                label = stringResource(R.string.button_text),
                onClick = { context.vibrate(); OnNavigateDetails(1) },
                icon = PhosphorIcons.Bold.ArrowElbowLeft,
                modifier = Modifier.fillMaxWidth()
            )

            QuickActionButton(
                label = stringResource(R.string.button_text),
                onClick = { context.vibrate(); context.playSound(R.raw.sound); OnNavigateDetails(2) },
                icon = PhosphorIcons.Bold.ArrowElbowLeft,
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}

