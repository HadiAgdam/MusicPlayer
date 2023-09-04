package com.hadiagdamapps.musicplayer

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class ActivityParent(val layout: Int) : AppCompatActivity() {


    abstract fun main()

    abstract fun initViews()


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(layout)
        initViews()
        main()
    }
}