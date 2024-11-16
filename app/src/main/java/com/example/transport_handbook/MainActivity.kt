package com.example.transport_handbook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.NonNull
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)
    }

    /**
     * Добавляем слушатель нажатий , события
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.car -> Toast.makeText(this, "Id car", Toast.LENGTH_SHORT).show()
            R.id.bus -> Toast.makeText(this, "Id bus", Toast.LENGTH_SHORT).show()
            R.id.aircraft -> Toast.makeText(this, "Id aircraft", Toast.LENGTH_SHORT).show()
            R.id.shiep -> Toast.makeText(this, "Id shiep", Toast.LENGTH_SHORT).show()
            R.id.bike -> Toast.makeText(this, "Id bike", Toast.LENGTH_SHORT).show()
            R.id.train -> Toast.makeText(this, "Id train", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}