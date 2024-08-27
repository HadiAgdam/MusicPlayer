package ir.hadiagdamapps.musicplayer.ui.viewmodels

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

    private val _playingSong = MutableLiveData<Song?>(null)
    val playingSong: LiveData<Song?> = _playingSong

    private val _progress = MutableLiveData(0f)
    val progress: LiveData<Float> = _progress

    private val _playing = MutableLiveData(false)
    val playing: LiveData<Boolean> = _playing


    fun updateProgressManual(progress: Float) {

    }

    fun skipNext() {

    }

    fun pausePlay() {

    }

    fun changeShuffle() {
        TODO()
    }

    fun changeOrder() {
        TODO()
    }

}