package ir.hadiagdamapps.musicplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ir.hadiagdamapps.musicplayer.ui.theme.primary


const val peekHeight = .1f

@Composable
fun CurrentSong(song: SongModel, progress: Float) {

    var fullScreen by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(if (fullScreen) 1f else peekHeight)
            .background(primary)
    ) {

        Peek(
            song = song,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(if (fullScreen) peekHeight else 1f),
            progress = progress
        )

    }
}


@Composable
fun Peek(
    modifier: Modifier = Modifier,
    song: SongModel, progress: Float
) {
    var sliderPosition by remember {
        mutableFloatStateOf(0f)
    }
    Column(modifier = modifier) {

        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })

    }

}
