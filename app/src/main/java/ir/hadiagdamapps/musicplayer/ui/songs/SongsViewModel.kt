package ir.hadiagdamapps.musicplayer.ui.songs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.hadiagdamapps.musicplayer.models.ShuffleMode
import ir.hadiagdamapps.musicplayer.models.Song

class SongsViewModel : ViewModel() {

    private val _songsList = MutableLiveData<List<Song>>()
    val songsList: LiveData<List<Song>> = _songsList

    private val _shuffleMode: MutableLiveData<ShuffleMode> = MutableLiveData(ShuffleMode.Repeat)
    val shuffleMode: LiveData<ShuffleMode> = _shuffleMode


    fun changeShuffle() {
        TODO()
    }

    fun changeOrder() {
        TODO()
    }

}