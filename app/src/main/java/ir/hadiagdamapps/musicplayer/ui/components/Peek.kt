package ir.hadiagdamapps.musicplayer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.hadiagdamapps.musicplayer.R
import ir.hadiagdamapps.musicplayer.ui.theme.Typography
import ir.hadiagdamapps.musicplayer.ui.theme.lightBackground
import ir.hadiagdamapps.musicplayer.ui.theme.primary

@Composable
fun Peek(
    modifier: Modifier = Modifier,
    songName: String,
    progress: Float,
    playing: Boolean,
    onProgressChange: (progress: Float) -> Unit,
    skipNextClick: () -> Unit,
    pausePlayClick: () -> Unit

) {
    Column(
        modifier = modifier
            .clip(
                CircleShape.copy(
                    topStart = CornerSize(24.dp), topEnd = CornerSize(24.dp),
                    bottomEnd = CornerSize(0.dp), bottomStart = CornerSize(0.dp)
                )
            )
            .background(lightBackground)
            .padding(16.dp)
    ) {

        Slider(
            value = progress,
            onValueChange = onProgressChange,
            colors = SliderDefaults.colors(
                thumbColor = primary,
                activeTrackColor = primary,
                inactiveTickColor = Color.White
            )
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "peek song image",
                    modifier = Modifier
                        .height(36.dp)
                        .width(64.dp)
                        .clip(
                            CircleShape.copy(
                                topStart = CornerSize(12.dp),
                                topEnd = CornerSize(12.dp),
                                bottomStart = CornerSize(12.dp),
                                bottomEnd = CornerSize(12.dp)
                            )
                        ), contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))
                Text(text = songName, style = Typography.titleSmall, color = Color.White)
            }


            Row {
                IconButton(onClick = pausePlayClick, modifier = Modifier.size(36.dp)) {
                    Icon(
                        painter = painterResource(
                            id =
                            if (playing)
                                R.drawable.pause_icon
                            else
                                R.drawable.play_icon
                        ),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                IconButton(onClick = skipNextClick, modifier = Modifier.size(36.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.skip_next_icon),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

        }

    }

}

@Preview
@Composable
fun PeekPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Peek(songName = "Song",
                progress = .5f,
                playing = true,
                onProgressChange = {},
                skipNextClick = {},
                pausePlayClick = {},
                modifier = Modifier.fillMaxHeight(.15f)
            )
        }
    }
}