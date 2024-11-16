package com.example.transport_handbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(listArray: ArrayList<ListItem>, context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var listArrayR = listArray
    private var contextR = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArrayR[position]

        holder.bind(listItem, contextR)

    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    /**\
     * через класс осуешствляем заполнение нашего ViewHolder параметрами
     *
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        private val tvContent = view.findViewById<TextView>(R.id.tvTitle)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bind(listItem: ListItem, context: Context) {
            tvTitle.text = listItem.titleText
            tvContent.text = listItem.content
            image.setImageResource(listItem.imageId)

            //слушатель нажатий на элементы
            itemView.setOnClickListener {
                Toast.makeText(context, "Pressed : ${tvTitle.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}