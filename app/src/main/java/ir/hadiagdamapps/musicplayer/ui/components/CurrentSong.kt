package ir.hadiagdamapps.musicplayer.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.hadiagdamapps.musicplayer.models.ShuffleMode
import ir.hadiagdamapps.musicplayer.models.Song
import ir.hadiagdamapps.musicplayer.ui.theme.Typography
import ir.hadiagdamapps.musicplayer.ui.theme.lightBackground
import ir.hadiagdamapps.musicplayer.ui.theme.lightBackgroundGradient
import ir.hadiagdamapps.musicplayer.ui.theme.primary


@Composable
fun CurrentSong(
    modifier: Modifier = Modifier,
    progress: Float,
    song: Song,
    playing: Boolean,
    onOrderChangeClick: () -> Unit,
    onPlayPauseClick: () -> Unit,
    onSkipNextClick: () -> Unit,
    onSkipPreviousClick: () -> Unit,
    onLikeClick: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxHeight(.9f)
            .fillMaxWidth()
            .background(lightBackgroundGradient)
            .padding(horizontal = 28.dp, vertical = 48.dp)
    ) {

        Text(text = song.name, style = Typography.titleLarge, color = primary)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = song.artist, style = Typography.bodyMedium)


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(560.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.CenterStart,

                ) {
                RotatingDisk(
                    modifier = Modifier.offset((-180).dp),
                    progress = progress,
                    null,
                )
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
                VerticalControlBar(
                    shuffleMode = ShuffleMode.Repeat,
                    playing = playing,
                    liked = song.liked,
                    onOrderChangeClick = onOrderChangeClick,
                    onSkipNextClick = onSkipNextClick,
                    onPausePlayClick = onPlayPauseClick,
                    onSkipPreviousClick = onSkipPreviousClick,
                    onLikeClick = onLikeClick)
            }
        }

    }
}

