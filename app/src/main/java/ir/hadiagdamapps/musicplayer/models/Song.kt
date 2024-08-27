package ir.hadiagdamapps.musicplayer.models

data class Song(
    val image: String, var name: String, val artist: Artist, var liked: Boolean = false
)


