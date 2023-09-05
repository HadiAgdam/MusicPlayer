package com.hadiagdamapps.musicplayer

import android.content.Context
import android.widget.LinearLayout
import android.widget.Toast


// In The Name Of Satan
class SongsAdapter(val context: Context, val data: SongsData, val container: LinearLayout) {

    private var list = ArrayList<SongModel>()

    fun search(query: String) {
        TODO("implement search filter and refresh linear layout content")
    }

    private fun loadItems(list: ArrayList<SongModel>) {
        for (i in list) {
            val view = object : SongItemLayout(context, i) {
                override fun favoriteClick() {
                    i.liked = !i.liked
                    data.getSongs()
                }
                override fun moreClick() {
                    Toast.makeText(context, "more clicked ${i.name}", Toast.LENGTH_SHORT).show()
                    TODO("Implement The Media Player Play Function And Pass The Model For That Function.")
                }
            }
            container.addView(view)
        }


    }


    // returns false if there is no music
    fun init(): Boolean {
        list = data.getSongs()!!
        loadItems(list)

        return list.size > 0
    }
}