package com.example.transport_handbook

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(listArray: ArrayList<ListItem>, context: Context) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
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
        private val tvContent = view.findViewById<TextView>(R.id.tvContent)
        private val tvImage = view.findViewById<ImageView>(R.id.tvImage)

        fun bind(listItem: ListItem, context: Context) {
            val textContent = listItem.content.substring(0, 50) + "..."
            tvTitle.text = listItem.title
            tvContent.text =  textContent
            tvImage.setImageResource(listItem.imageId)

            //слушатель нажатий на элементы
            itemView.setOnClickListener {
                Toast.makeText(context, "Pressed : ${tvTitle.text}", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ContentActivity::class.java).apply {
                    putExtra("title", tvTitle.text.toString())    //помещаем данные в элементы другой активити
                    putExtra("content",listItem.content)
                    putExtra("image", listItem.imageId)
                }
                context.startActivity(intent)
            }
        }
    }

    /**
     * ф-я  Обновления списка
     */
    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listArray: List<ListItem>) {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}