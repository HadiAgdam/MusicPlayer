package ir.hadiagdamapps.musicplayer.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val primary = Color(0xFF09307F)
val secondary = Color(0xFF6BA6CF)

val darkBackground = Color(0xFF151520)
val lightBackground = Color(0xFFD6E5F4)

val lightBackgroundGradient = Brush.linearGradient(
    colors = listOf(lightBackground, Color(0xFFBCD3E8)),
    start = androidx.compose.ui.geometry.Offset(0f, 0f),
    end = androidx.compose.ui.geometry.Offset(1000f, 1000f)
)

