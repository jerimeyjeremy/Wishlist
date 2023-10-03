package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var items: MutableList<Item>
    lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button3)
        val itemNameEditText = findViewById<EditText>(R.id.itemName)
        val amountEditText = findViewById<EditText>(R.id.editTextNumber)
        val urlEditText = findViewById<EditText>(R.id.url)
        val itemRv = findViewById<RecyclerView>(R.id.recyclerView)

        //items = ItemFetcher.getItemList()
        items = mutableListOf()

        val adapter = ItemAdapter(items)
        itemRv.adapter = adapter
        itemRv.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            val itemName = itemNameEditText.text.toString()
            val amountText = amountEditText.text.toString()
            val url = urlEditText.text.toString()

            if (itemName.isNotEmpty() && url.isNotEmpty() && amountText.isNotEmpty()) {
                //val newItem = Item(itemName, amountText, url)
               // ItemFetcher.addItem(newItem)
                var newItem : Item = Item(
                    itemName,
                    amountText,
                    url
                )
                items.add(newItem)
                // Clear the EditText fields after adding the item
                itemNameEditText.text.clear()
                urlEditText.text.clear()
                amountEditText.text.clear()

                // Notify the adapter that the data has changed

                adapter.notifyDataSetChanged()
            }
        }
    }
}
