package ir.hadiagdamapps.musicplayer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.hadiagdamapps.musicplayer.ui.theme.MusicPlayerTheme
import ir.hadiagdamapps.musicplayer.ui.theme.darkBackground

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MusicViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicPlayerTheme {

                MainScreen(
                    list = viewModel.songsList,
                    shuffleMode = viewModel.shuffleMode,
                    changeShuffle = viewModel::changeShuffle,
                    changeOrderClick = viewModel::changeOrder
                )

            }
        }
    }
}


@Composable
fun TopSearchBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(86.dp)
            .fillMaxWidth()
            .background(Color.Black)
    ) {

    }
}

@Composable
fun MainScreen(
    list: List<SongModel>,
    shuffleMode: ShuffleMode,
    changeShuffle: () -> Unit,
    changeOrderClick: () -> Unit
) {
    Surface {
        Scaffold(topBar = {
            TopSearchBar()
        }) {

            MusicContainer(
                modifier = Modifier.padding(it),
                list = list,
                shuffleMode = shuffleMode,
                shuffleClick = changeShuffle,
                orderClick = changeOrderClick
            )


        }
    }
}


@Composable
fun MusicContainer(
    modifier: Modifier = Modifier,
    list: List<SongModel>,
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


@Preview
@Composable
fun Preview() {

}


