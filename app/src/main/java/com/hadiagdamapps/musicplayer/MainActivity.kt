package com.hadiagdamapps.musicplayer

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged

class MainActivity : ActivityParent(R.layout.activity_main) {


    private lateinit var recentlyContainer: LinearLayout
    private lateinit var recentlyLinearLayout: LinearLayout
    private lateinit var noContentText: TextView
    private lateinit var musicsLinearLayout: LinearLayout
    private lateinit var searchBar: AppCompatEditText

    private val data = SongsData()
    lateinit var songsAdapter: SongsAdapter

    private fun initRecently() {
        val list = data.getRecentlyPlayed()

        if (list == null)
            recentlyContainer.visibility = View.GONE
        else for (i in list)
            recentlyLinearLayout.addView(RecentlyItemLayout(this, i))

    }

    private fun initSongs() {
        if (!songsAdapter.init()) {
            noContentText.visibility = View.VISIBLE
        }

    }

    override fun main() {
        initRecently()
        initSongs()
        songsAdapter = SongsAdapter(this, data, musicsLinearLayout)
    }

    override fun initViews() {
        recentlyContainer = findViewById(R.id.recentlyContainer)
        recentlyLinearLayout = findViewById(R.id.recentlyLinear)
        noContentText = findViewById(R.id.noContentText)
        musicsLinearLayout = findViewById(R.id.musicsLinear)
        searchBar = findViewById(R.id.searchView)
        searchBar.doOnTextChanged { _, _, _, _ -> songsAdapter.search(searchBar.text.toString()) }
    }
}