package ir.hadiagdamapps.musicplayer.ui.songs

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import ir.hadiagdamapps.musicplayer.models.ShuffleMode
import ir.hadiagdamapps.musicplayer.ui.theme.MusicPlayerTheme

@Composable
fun SongScreen() {

    val viewModel: SongsViewModel = SongsViewModel()

    val songsList by viewModel.songsList.observeAsState(emptyList())
    val shuffleMode by viewModel.shuffleMode.observeAsState(ShuffleMode.Repeat)

    MusicPlayerTheme {

        Scaffold(
            topBar = { TopSearchBar() },
        ) {

            SongsListContainer(
                modifier = Modifier.padding(it),
                list = songsList,
                shuffleMode = shuffleMode,
                shuffleClick = viewModel::changeShuffle,
                orderClick = viewModel::changeOrder
            )

        }
    }
}


