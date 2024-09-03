package ir.hadiagdamapps.musicplayer.ui.viewmodels

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import android.media.MediaMetadataRetriever
import android.media.MediaPlayer
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.hadiagdamapps.musicplayer.models.ShuffleMode
import ir.hadiagdamapps.musicplayer.models.Song
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SongsViewModel : ViewModel() {

    private val _songsList = MutableStateFlow<List<Song>>(emptyList())
    val songsList: StateFlow<List<Song>> = _songsList.asStateFlow()

    private val _shuffleMode: MutableLiveData<ShuffleMode> = MutableLiveData(ShuffleMode.Repeat)
    val shuffleMode: LiveData<ShuffleMode> = _shuffleMode

    private val _playingSong = MutableLiveData<Song?>(null)
    val playingSong: LiveData<Song?> = _playingSong

    private val _progress = MutableLiveData(0f)
    val progress: LiveData<Float> = _progress

    private val _playing = MutableLiveData(false)
    val playing: LiveData<Boolean> = _playing

    private val mediaPlayer: MediaPlayer = MediaPlayer()
    private var currentSongIndex: Int = -1

    init {
        mediaPlayer.setOnCompletionListener {
            skipNext()
        }
    }

    private fun getAlbumArtUri(albumId: Long): String? {
        val uri = Uri.parse("content://media/external/audio/albumart")
        return Uri.withAppendedPath(uri, albumId.toString()).toString()
    }

    fun fetchSongs(contentResolver: ContentResolver) {
        val songs = mutableListOf<Song>()

        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.ALBUM_ID
        )

        val selection = "${MediaStore.Audio.Media.IS_MUSIC} != 0"
        val sortOrder = "${MediaStore.Audio.Media.TITLE} ASC"

        val cursor = contentResolver.query(uri, projection, selection, null, sortOrder)
        cursor?.use {
            val idColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
            val titleColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
            val artistColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
            val durationColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)
            val dataColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
            val albumIdColumn = it.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID)

            while (it.moveToNext()) {
                val id = it.getLong(idColumn)
                val title = it.getString(titleColumn)
                val artist = it.getString(artistColumn)
                val duration = it.getLong(durationColumn)
                val data = it.getString(dataColumn)
                val albumId = it.getLong(albumIdColumn)

                val image = getAlbumArtUri(albumId)

                val song = Song(
                    id = id,
                    image = image,
                    name = title,
                    artist = artist,
                    liked = false,
                    duration = duration,
                    data = data
                )

                songs.add(song)
            }
        }
        _songsList.value = songs
    }

    fun updateProgressManual(progress: Float) {
        mediaPlayer.let {
            val newProgress = (it.duration * progress).toInt()
            it.seekTo(newProgress)
            _progress.value = progress
        }
    }

    fun skipNext() {
        val songs = _songsList.value
        if (songs.isNotEmpty()) {
            currentSongIndex = (currentSongIndex + 1) % songs.size
            playSong(songs[currentSongIndex])
        }
    }

    fun skipPrevious() {
        val songs = _songsList.value
        if (songs.isNotEmpty()) {
            currentSongIndex = if (currentSongIndex > 0) currentSongIndex - 1 else songs.size - 1
            playSong(songs[currentSongIndex])
        }
    }

    fun like(song: Song) {
        song.liked = !song.liked
        _songsList.value = _songsList.value.map {
            if (it.id == song.id) song else it
        }
    }

    fun pausePlay() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            _playing.value = false
        } else {
            mediaPlayer.start()
            _playing.value = true
        }
    }

    fun changeShuffle() {
        val currentMode = _shuffleMode.value ?: ShuffleMode.Repeat
        _shuffleMode.value = when (currentMode) {
            ShuffleMode.Shuffle -> ShuffleMode.Repeat
            ShuffleMode.Repeat -> ShuffleMode.NoRepeat
            ShuffleMode.NoRepeat -> ShuffleMode.Shuffle
        }
    }

    fun playSong(song: Song) {
        mediaPlayer.reset()
        mediaPlayer.setDataSource(song.data)
        mediaPlayer.prepare()
        mediaPlayer.start()
        _playingSong.value = song
        _playing.value = true
        _progress.value = 0f
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer.release()
    }
}
