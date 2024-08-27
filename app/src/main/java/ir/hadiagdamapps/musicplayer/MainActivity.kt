package ir.hadiagdamapps.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.hadiagdamapps.musicplayer.navigation.Screen
import ir.hadiagdamapps.musicplayer.ui.screens.CurrentSongScreen
import ir.hadiagdamapps.musicplayer.ui.screens.SongScreen
import ir.hadiagdamapps.musicplayer.ui.viewmodels.SongsViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MusicPlayerApp()
        }
    }
}

@Composable
fun MusicPlayerApp() {
    val viewModel: SongsViewModel = viewModel()

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SongsScreen.route) {

        composable(Screen.SongsScreen.route) {
            SongScreen(navController, viewModel)
        }

        composable(Screen.CurrentSongScreen.route) {
            CurrentSongScreen(navController, viewModel)
        }

    }

}


