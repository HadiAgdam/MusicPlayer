package ir.hadiagdamapps.musicplayer.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import ir.hadiagdamapps.musicplayer.models.ShuffleMode
import ir.hadiagdamapps.musicplayer.navigation.Screen
import ir.hadiagdamapps.musicplayer.ui.components.CurrentSong
import ir.hadiagdamapps.musicplayer.ui.components.Peek
import ir.hadiagdamapps.musicplayer.ui.components.SongItem
import ir.hadiagdamapps.musicplayer.ui.viewmodels.SongsViewModel

@Composable
fun CurrentSongScreen(navController: NavController, viewModel: SongsViewModel) {

    val playingSong by viewModel.playingSong.observeAsState(null)
    val progress by viewModel.progress.observeAsState(0f)
    val playing by viewModel.playing.observeAsState(false)


    if (playingSong == null) {
        navController.navigate(Screen.CurrentSongScreen.route)
        return
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Peek(
            modifier = Modifier.fillMaxHeight(.1f),
            songName = playingSong!!.name,
            progress = progress,
            playing = playing,
            onProgressChange = viewModel::updateProgressManual,
            skipNextClick = viewModel::skipNext,
            pausePlayClick = viewModel::pausePlay
        )
        CurrentSong(
            progress = progress,
            song = playingSong!!,
            playing = playing,
            onOrderChangeClick = viewModel::changeOrder,
            onPlayPauseClick = viewModel::pausePlay,
            onSkipNextClick = viewModel::skipNext,
            onSkipPreviousClick = viewModel::skipPrevious,
            onLikeClick = { viewModel.like(playingSong!!) })
    }

}