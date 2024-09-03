package ir.hadiagdamapps.musicplayer.models

import androidx.annotation.DrawableRes
import ir.hadiagdamapps.musicplayer.R

enum class ShuffleMode(@DrawableRes val painterResId: Int) {
     Repeat(R.drawable.shuffle_repeat_one_icon),
    Shuffle(R.drawable.shuffle_repeat_icon), // TODO
    NoRepeat(R.drawable.shuffle_random_icon), // TODO

}
