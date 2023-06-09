package com.example.navigationdrawerfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navigationdrawer.R
import com.example.navigationdrawer.fragments.ChatFragment
import com.example.navigationdrawer.fragments.MessageFragment
import com.example.navigationdrawer.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this@MainActivity, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState() //sync the toolbar and the drawer

        supportFragmentManager  //(optional default selected fragment)
            .beginTransaction()
            .replace(R.id.fragment_container, MessageFragment())
            .commit()  //building the fragment
        navigationView.setCheckedItem(R.id.nav_message) // selected fragment to screen


        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_message -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, MessageFragment())
                        .commit()  //if the item id is message then build message Fragment
                }

                R.id.nav_chat -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, ChatFragment())
                        .commit()
                }

                R.id.nav_profile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, ProfileFragment())
                        .commit()
                }
                R.id.nav_send -> {
                    Toast.makeText(this@MainActivity, "Send clicked", Toast.LENGTH_SHORT).show()
                }

                R.id.nav_share -> {
                    Toast.makeText(this@MainActivity, "Share clicked", Toast.LENGTH_SHORT)
                        .show()

                }
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) { //if the drawer is opened then it closes it
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed() //when back button is pressed removes the drawer and it will not quit the app
        }
    }
}