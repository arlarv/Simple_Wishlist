package com.example.simplewishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val dataset: List<ItemData>) :
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    // ViewHolder class to hold references to the views in each item layout
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemNameTextView: TextView = view.findViewById(R.id.itemNameTV)
        val itemPriceTextView: TextView = view.findViewById(R.id.itemPriceTV)
        val itemURLTextView: TextView = view.findViewById(R.id.itemURLTV)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the item layout (wishlist_item.xml) for each item in the RecyclerView
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(view) // Create and return a ViewHolder for the item
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the item from the dataset at the specified position
        val item = dataset[position]

        // Bind data from the item to the corresponding TextViews in the ViewHolder
        holder.itemNameTextView.text = item.itemName
        holder.itemPriceTextView.text = item.itemPrice
        holder.itemURLTextView.text = item.itemURL
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataset.size
}