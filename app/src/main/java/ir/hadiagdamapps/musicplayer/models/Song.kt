package ir.hadiagdamapps.musicplayer.models

data class Song(
    val id: Long,
    val image: String?,
    var name: String,
    val artist: String,
    var liked: Boolean = false,
    val duration: Long,
    val data: String
)


