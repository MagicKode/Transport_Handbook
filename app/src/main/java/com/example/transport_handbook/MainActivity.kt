package com.example.transport_handbook

import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var adapter: MyAdapter? = null
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val list = ArrayList<ListItem>()

        list.addAll(
            fillArrays(
                resources.getStringArray(R.array.transport),
                resources.getStringArray(R.array.transport_content),
                getImageId(R.array.transport_image_array)
            )
        )

        val rcView = findViewById<RecyclerView>(R.id.rcView)
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter
    }

    /**
     * Добавляем слушатель нажатий , события
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.car -> {
                Toast.makeText(this, "Id car", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.transport),
                        resources.getStringArray(R.array.transport_content),
                        getImageId(R.array.transport_image_array)
                    )
                )
            }

            R.id.bus -> {
                Toast.makeText(this, "Id bus", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(
                    fillArrays(
                        resources.getStringArray(R.array.transport_example),
                        resources.getStringArray(R.array.transport_content_example),
                        getImageId(R.array.transport_image_array_example)
                    )
                )
            }

            R.id.aircraft -> Toast.makeText(this, "Id aircraft", Toast.LENGTH_SHORT).show()
            R.id.shipe -> Toast.makeText(this, "Id shpe", Toast.LENGTH_SHORT).show()
            R.id.bike -> Toast.makeText(this, "Id bike", Toast.LENGTH_SHORT).show()
            R.id.train -> Toast.makeText(this, "Id train", Toast.LENGTH_SHORT).show()
        }

        return true
    }

    private fun fillArrays(
        titleArray: Array<String>,
        contentArray: Array<String>,
        imageArray: IntArray
    ): List<ListItem> {
        val listItemArray = ArrayList<ListItem>()
        for (n in titleArray.indices) {
            val listItem = ListItem(titleArray[n], contentArray[n], imageArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    /**
     * ф-я для расшифровки картинок для передачи в массив
     */
    private fun getImageId(imageArrayId: Int): IntArray {
        val tArray: TypedArray =
            resources.obtainTypedArray(imageArrayId)  //получаем для расшифровки id
        val count = tArray.length()
        val ids = IntArray(count)

        for (i in ids.indices) {
            ids[i] = tArray.getResourceId(i, 0)  //циклом берём идентификатор каждого
        }
        tArray.recycle()  //для повторения

        return ids
    }
}