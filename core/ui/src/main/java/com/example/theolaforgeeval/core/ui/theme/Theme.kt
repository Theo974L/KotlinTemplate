package com.example.theolaforgeeval.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val LightColorScheme = lightColorScheme(
    primary      = AppColors.Primary,
    onPrimary    = Color.White,
    secondary    = AppColors.Secondary,
    onSecondary  = Color.White,
    tertiary     = AppColors.Tertiary,
    onTertiary   = AppColors.TextPrimaryLight,

    background   = AppColors.BackgroundLight,
    onBackground = AppColors.TextPrimaryLight,
    surface      = AppColors.SurfaceLight,
    onSurface    = AppColors.TextPrimaryLight,
)


private val DarkColorScheme = darkColorScheme(
    primary      = AppColors.Secondary,
    onPrimary    = AppColors.TextPrimaryDark,
    secondary    = AppColors.Tertiary,
    onSecondary  = AppColors.TextPrimaryDark,
    tertiary     = AppColors.Primary,

    background   = AppColors.BackgroundDark,
    onBackground = AppColors.TextPrimaryDark,
    surface      = AppColors.SurfaceDark,
    onSurface    = AppColors.TextPrimaryDark
)


@Composable
fun TheoLaforgeEvalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val colorScheme = remember(darkTheme, dynamicColor) {
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {

                try {
                    if (darkTheme) dynamicDarkColorScheme(context)
                    else dynamicLightColorScheme(context)
                } catch (e: Exception) {
                    if (darkTheme) DarkColorScheme else LightColorScheme
                }
            }
            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }
    }


    MaterialTheme(
        colorScheme = colorScheme,
        // typography = Typography, // à activer plus tard si tu veux une typographie custom
        content = content
    )
}