package com.stopstone.shoppingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationHome = findViewById<BottomNavigationView>(R.id.bottom_navigation_home)
        bottomNavigationHome.itemIconTintList = null
    }
}