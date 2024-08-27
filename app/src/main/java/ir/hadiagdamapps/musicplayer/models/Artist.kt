package ir.hadiagdamapps.musicplayer.models

class Artist private constructor(val name: String) {
    companion object {
        fun parse(text: String): Artist? {
            return Artist(text)
        }
    }
}