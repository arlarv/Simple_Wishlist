package com.example.simplewishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplewishlist.ItemData
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextPrice: EditText
    private lateinit var editTextURL: EditText
    private lateinit var buttonAddItem: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var wishlistAdapter: WishlistAdapter
    private val wishListItems = ArrayList<ItemData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.nameInput)
        editTextPrice = findViewById(R.id.priceInput)
        editTextURL = findViewById(R.id.urlInput)
        buttonAddItem = findViewById(R.id.submitButton)
        recyclerView = findViewById(R.id.wishlistRV)

        wishlistAdapter = WishlistAdapter(wishListItems)
        recyclerView.adapter = wishlistAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        buttonAddItem.setOnClickListener{
            val itemName = editTextName.text.toString()
            val itemPrice = editTextPrice.text.toString()
            val itemURL = editTextURL.text.toString()

            val newItem = ItemData(itemName, itemPrice, itemURL)
            wishListItems.add(newItem)
            wishlistAdapter.notifyDataSetChanged()
            editTextName.text.clear()
            editTextPrice.text.clear()
            editTextURL.text.clear()
        }

    }
}