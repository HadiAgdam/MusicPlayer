package ir.hadiagdamapps.musicplayer.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.hadiagdamapps.musicplayer.R
import ir.hadiagdamapps.musicplayer.models.ShuffleMode
import ir.hadiagdamapps.musicplayer.models.Song
import ir.hadiagdamapps.musicplayer.ui.theme.darkBackground

@Composable
fun SongsListContainer(
    modifier: Modifier = Modifier,
    list: List<Song>,
    shuffleMode: ShuffleMode,
    shuffleClick: () -> Unit,
    orderClick: () -> Unit,
) {

    var r by remember {
        mutableStateOf(list)
    }

    Column(
        modifier = modifier
            .background(darkBackground)
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "All songs",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
            )
            Row {
                IconButton(onClick = shuffleClick) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = shuffleMode.painterResId),
                        contentDescription = "shuffle icon",
                        tint = Color.White
                    )
                }
                IconButton(onClick = orderClick) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.sort_icon),
                        contentDescription = "order icon",
                        tint = Color.White
                    )
                }
            }
        }

        LazyColumn {
            itemsIndexed(r) { _, model ->
                var liked by rememberSaveable { mutableStateOf(model.liked) }
                SongItem(
                    model = model,
                    onLikeClick = { liked = !liked },
                    onClick = {},
                    liked = liked
                )
            }
        }

    }
}