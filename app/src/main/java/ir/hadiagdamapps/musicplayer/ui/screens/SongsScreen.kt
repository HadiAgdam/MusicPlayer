package ir.hadiagdamapps.musicplayer.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ir.hadiagdamapps.musicplayer.models.ShuffleMode
import ir.hadiagdamapps.musicplayer.ui.components.SongsListContainer
import ir.hadiagdamapps.musicplayer.ui.components.TopSearchBar
import ir.hadiagdamapps.musicplayer.ui.theme.MusicPlayerTheme
import ir.hadiagdamapps.musicplayer.ui.viewmodels.SongsViewModel

@Composable
fun SongScreen(navController: NavController, viewModel: SongsViewModel) {

    val songsList by viewModel.songsList.collectAsState()
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
                onOrderChangeClick = viewModel::changeOrder,
                onLikeClick = viewModel::like
            )

        }
    }
}


