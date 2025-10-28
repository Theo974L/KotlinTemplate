package com.example.theolaforgeeval.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.adamglin.PhosphorIcons
import com.adamglin.phosphoricons.Bold
import com.adamglin.phosphoricons.bold.Cards
import com.adamglin.phosphoricons.bold.Option


sealed class BottomNavScreen(val route: String, val label: String, val icon: ImageVector) {
    object NoName1 : BottomNavScreen("NoName1", "NoName 1", PhosphorIcons.Bold.Option)
    object Home : BottomNavScreen("home", "Accueil", Icons.Default.Home)
    object NoName2 : BottomNavScreen("NoName2", "NoName 2", PhosphorIcons.Bold.Cards)
}


@Composable
fun BottomNavigationBar(onItemClick: NavController) {
    val screens = listOf(
        BottomNavScreen.NoName1,
        BottomNavScreen.Home,
        BottomNavScreen.NoName2
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        screens.forEach { screen ->
            BottomNavItem(
                label = screen.label,
                icon = screen.icon) {
                onItemClick.navigate(screen.route)
            }

        }

    }


}

@Composable
fun BottomNavItem(label: String, icon: ImageVector, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable { onClick() }) {
        Icon(icon, contentDescription = label, tint = MaterialTheme.colorScheme.onBackground)
        Text(label, color = MaterialTheme.colorScheme.onBackground, fontSize = 12.sp)
    }
}