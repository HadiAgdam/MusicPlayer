package com.hadiagdamapps.musicplayer

import android.content.Context
import android.widget.LinearLayout

class SongsAdapter(val context: Context, val data: SongsData, val container: LinearLayout) {



    fun search(query: String) {
        TODO("implement search filter and refresh linear layout content")
    }


    // returns false if there is no music
    fun init() : Boolean {
        TODO("load the music from data")
    }
}