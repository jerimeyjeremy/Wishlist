package com.example.wishlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: MutableList<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val nameTextView: TextView
        val amountTextView: TextView
        val urlTextView: TextView

        init {
            nameTextView  = itemView.findViewById(R.id.nameTv)
            amountTextView = itemView.findViewById(R.id.amountTv)
            urlTextView = itemView.findViewById(R.id.urlTv)
        }


    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
            val context = parent.context
            val inflater = LayoutInflater.from(context)
            val listView = inflater.inflate(R.layout.item_item, parent, false)

            return ViewHolder(listView)
        }

        override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
            // Get the data model based on position
            val item = items[position]
            // Set item views based on views and data model
            holder.nameTextView.text = item.name
            holder.amountTextView.text = item.amount.toString()
            holder.urlTextView.text = item.url
        }

        override fun getItemCount(): Int {
            return items.size
        }


}
