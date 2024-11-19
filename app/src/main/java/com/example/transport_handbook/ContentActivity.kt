package com.example.transport_handbook

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)

        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvContent = findViewById<TextView>(R.id.tvContent)
        val tvImage = findViewById<ImageView>(R.id.tvImage)

        tvTitle.text = intent.getStringExtra("title")
        tvContent.text = intent.getStringExtra("content")
        tvImage.setImageResource(intent.getIntExtra("image", R.drawable.car))
    }
}