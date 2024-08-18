package ir.hadiagdamapps.musicplayer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MusicViewModel : ViewModel() {

    private val _songsList = mutableStateListOf<SongModel>()
    val songsList: List<SongModel> = _songsList

    var shuffleMode by mutableStateOf(ShuffleMode.Repeat)
        private set

    fun changeShuffle() {
        TODO()
    }

    fun changeOrder() {
        TODO()
    }

}