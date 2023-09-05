package com.hadiagdamapps.musicplayer

class SongsData() {


    fun getRecentlyPlayed(): ArrayList<SongModel>? {
        TODO("get musics from storage")
    }


    fun getSongs(): ArrayList<SongModel>? {
        TODO("implement the loadings songs from storage")
    }

    fun like(songModel: SongModel, liked: Boolean) {
        TODO("update liked status")
    }

}