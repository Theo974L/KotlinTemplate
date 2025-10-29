package com.example.theolaforgeeval.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TypeChip(type: String) {
    val typeColor = when (type.lowercase()) {
        "feu" -> Color(0xFFEE8130)
        "eau" -> Color(0xFF6390F0)
        "plante" -> Color(0xFF7AC74C)
        "électrik", "electrik" -> Color(0xFFF7D02C)
        "glace" -> Color(0xFF96D9D6)
        "combat" -> Color(0xFFC22E28)
        "psy" -> Color(0xFFF95587)
        "sol" -> Color(0xFFE2BF65)
        "insecte" -> Color(0xFFA6B91A)
        "spectre" -> Color(0xFF735797)
        "dragon" -> Color(0xFF6F35FC)
        "ténèbres", "tenebres" -> Color(0xFF705746)
        "acier" -> Color(0xFFB7B7CE)
        "fée" -> Color(0xFFD685AD)
        else -> Color(0xFF8D8D8D)
    }

    Box(
        modifier = Modifier
            .background(typeColor, shape = RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = type.replaceFirstChar { it.uppercase() },
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}
