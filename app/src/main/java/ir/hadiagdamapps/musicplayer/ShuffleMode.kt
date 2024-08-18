package ir.hadiagdamapps.musicplayer

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

sealed class ShuffleMode(@DrawableRes val painterResId: Int) {
     data object Repeat : ShuffleMode(R.drawable.shuffle_repeat_icon)

}
