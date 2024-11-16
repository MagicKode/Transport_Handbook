package com.example.transport_handbook

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)

        val list = ArrayList<ListItem>()
        list.add(ListItem(R.drawable.car, "Car", "description"))
        list.add(ListItem(R.drawable.aircraft, "Aircraft", "description"))
        list.add(ListItem(R.drawable.shipe, "Shipe", "description"))
        list.add(ListItem(R.drawable.bike, "Bike", "description"))
        list.add(ListItem(R.drawable.train, "Train", "description"))
        list.add(ListItem(R.drawable.bus, "Bus", "description"))

        val rcView = findViewById<RecyclerView>(R.id.rcView)
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        rcView.adapter = MyAdapter(list, this)
    }

    /**
     * Добавляем слушатель нажатий , события
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.car -> Toast.makeText(this, "Id car", Toast.LENGTH_SHORT).show()
            R.id.bus -> Toast.makeText(this, "Id bus", Toast.LENGTH_SHORT).show()
            R.id.aircraft -> Toast.makeText(this, "Id aircraft", Toast.LENGTH_SHORT).show()
            R.id.shipe -> Toast.makeText(this, "Id shpe", Toast.LENGTH_SHORT).show()
            R.id.bike -> Toast.makeText(this, "Id bike", Toast.LENGTH_SHORT).show()
            R.id.train -> Toast.makeText(this, "Id train", Toast.LENGTH_SHORT).show()
        }

        return true
    }
}