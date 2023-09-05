package com.hadiagdamapps.musicplayer

import android.content.Context
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class RecentlyItemLayout(context: Context, val songModel: SongModel) : FrameLayout(context) {

    init {
        inflate(context, R.layout.recently_item_layout, this)

        Glide.with(this).load(songModel.image).into(findViewById<ImageView>(R.id.image))

        setOnClickListener { songModel.click() }
    }

}

abstract class SongItemLayout(context: Context, private val model: SongModel) :
    FrameLayout(context) {

    private var favorite = false

    private fun updateLikeIcon() {
        findViewById<ImageView>(R.id.heartIcon).setImageResource(if (favorite) R.drawable.heart_filled else R.drawable.heart_border)
    }

    abstract fun favoriteClick()

    abstract fun moreClick()

    init {
        inflate(context, R.layout.music_item_layout, this)
        favorite = model.liked


        findViewById<TextView>(R.id.nameText).text = model.name
        findViewById<TextView>(R.id.singerText).text = model.singer
        Glide.with(context).load(model.image).into(findViewById(R.id.image))

        findViewById<ImageView>(R.id.heartIcon).setOnClickListener {
            favorite = !favorite
            updateLikeIcon()
            favoriteClick()

        }

        findViewById<ImageView>(R.id.moreIcon).setOnClickListener {
            moreClick()
        }

    }

}