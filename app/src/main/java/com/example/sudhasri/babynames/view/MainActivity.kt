package com.example.sudhasri.babynames.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.sudhasri.babynames.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.list_container, NameListFragment.getInstance())
        ft.commit()
    }
}
