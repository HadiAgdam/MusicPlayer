package ir.hadiagdamapps.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ir.hadiagdamapps.musicplayer.ui.screens.SongScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            SongScreen()
        }
    }
}

//private val viewModel by viewModels<MusicViewModel>()
