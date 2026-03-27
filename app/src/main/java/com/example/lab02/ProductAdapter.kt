/**
 * Course: MAD302 - Mobile Application Development
 * Lab: Lab 02 - RecyclerView & Navigation
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date: 2026-03-27
 * Description: RecyclerView Adapter that binds Product data to item_product.xml views.
 *              Supports lambda-based click handling for navigation.
 */

package com.example.lab02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for displaying a list of products in a RecyclerView.
 *
 * @property products List of Product objects to display
 * @property onProductClick Lambda callback invoked when a product card is tapped.
 *                          Receives the tapped Product as a parameter.
 */
class ProductAdapter(
    private val products: List<Product>,
    private val onProductClick: (Product) -> Unit  // lambda click handler
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    /**
     * ViewHolder that holds references to all views within a single product card.
     * Avoids repeated findViewById calls during scrolling for better performance.
     *
     * @param itemView The inflated item_product.xml view
     */
    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
    }

    /**
     * Inflates the item_product.xml layout and returns a new ProductViewHolder.
     *
     * @param parent The ViewGroup into which the new view will be added
     * @param viewType The view type (not used here, only one type)
     * @return A new ProductViewHolder wrapping the inflated view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // Inflate the card layout for each product row
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    /**
     * Binds a Product's data to the views in the given ViewHolder.
     * Also attaches the click listener using a lambda expression.
     *
     * @param holder The ViewHolder to bind data into
     * @param position The index of the product in the list
     */
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]  // get product at this position

        // Bind each field to its corresponding TextView
        holder.tvProductName.text = product.name
        holder.tvDescription.text = product.description
        holder.tvPrice.text = "$${String.format("%.2f", product.price)}"
        holder.tvCategory.text = product.category
        holder.tvRating.text = "★ ${product.rating}"

        // Lambda-based click handling — passes the product to the callback
        holder.itemView.setOnClickListener {
            onProductClick(product)
        }
    }

    /**
     * Returns the total number of products in the list.
     * Required by RecyclerView.Adapter.
     *
     * @return Size of the products list
     */
    override fun getItemCount(): Int = products.size
}