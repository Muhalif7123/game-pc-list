package com.belajar.finalproject

import android.app.TaskStackBuilder
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.view.SupportActionModeWrapper

class AboutPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_page)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar
        supportActionBar?.apply {
            title = "About"
        }
    }

}