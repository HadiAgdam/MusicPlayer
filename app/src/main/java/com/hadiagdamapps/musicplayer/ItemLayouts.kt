package com.hadiagdamapps.musicplayer

import android.content.Context
import android.widget.FrameLayout
import android.widget.ImageView
import com.bumptech.glide.Glide


class RecentlyItemLayout(context: Context, val songModel: SongModel) : FrameLayout(context) {

    init {
        inflate(context, R.layout.recently_item_layout, this)

        Glide.with(this).load(songModel.image).into(findViewById<ImageView>(R.id.image))

        setOnClickListener { songModel.click() }
    }

}