package ir.hadiagdamapps.musicplayer.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.hadiagdamapps.musicplayer.R
import ir.hadiagdamapps.musicplayer.models.ShuffleMode
import ir.hadiagdamapps.musicplayer.ui.theme.darkBackground
import ir.hadiagdamapps.musicplayer.ui.theme.lightBackground
import ir.hadiagdamapps.musicplayer.ui.theme.primary
import ir.hadiagdamapps.musicplayer.ui.theme.secondary


@Composable
fun VerticalControlBar(
    shuffleMode: ShuffleMode,
    playing: Boolean,
    liked: Boolean,
    reOrderClick: () -> Unit,
    skipNextClick: () -> Unit,
    pausePlayClick: () -> Unit,
) {
    val space = 24.dp
    Column(
        modifier = Modifier
            .width(56.dp)
            .clip(RoundedCornerShape(100))
            .background(Color.White)
            .padding(3.dp)
            .clip(RoundedCornerShape(100))
            .background(lightBackground)
            .clip(RoundedCornerShape(100))
            .padding(vertical = space),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        IconButton(onClick = reOrderClick) {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                painter = painterResource(id = shuffleMode.painterResId),
                contentDescription = "shuffle icon",
                tint = secondary
            )
        }
        Spacer(modifier = Modifier.height(space))
        IconButton(onClick = skipNextClick) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.skip_next_icon),
                contentDescription = "skip next icon",
                tint = secondary
            )
        }
        Spacer(modifier = Modifier.height(space))
        IconButton(onClick = skipNextClick) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = if (playing) R.drawable.pause_icon else R.drawable.play_icon),
                contentDescription = "pause play icon",
                tint = secondary
            )
        }
        Spacer(modifier = Modifier.height(space))
        IconButton(onClick = skipNextClick) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.skip_previous_icon),
                contentDescription = "skip previous icon",
                tint = secondary
            )
        }
        Spacer(modifier = Modifier.height(space))
        IconButton(onClick = skipNextClick) {
            Icon(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp),
                painter = painterResource(id = if (liked) R.drawable.favorite_filled_icon else R.drawable.favorite_border_icon),
                contentDescription = "like icon",
                tint = if (liked) Color.Red else primary
            )
        }

    }
}

@Preview
@Composable
fun VerticalControlBarPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        VerticalControlBar(ShuffleMode.Repeat,
            playing = true,
            liked = true,
            reOrderClick = {},
            skipNextClick = {},
            pausePlayClick = {})
    }
}