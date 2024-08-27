package ir.hadiagdamapps.musicplayer.models

import androidx.annotation.DrawableRes
import ir.hadiagdamapps.musicplayer.R

enum class ShuffleMode(@DrawableRes val painterResId: Int) {
     Repeat(R.drawable.shuffle_repeat_one_icon)
}
