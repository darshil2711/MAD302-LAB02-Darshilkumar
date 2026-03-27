/**
 * Course: MAD302 - Mobile Application Development
 * Lab: Lab 02 - RecyclerView & Navigation
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date: 2026-03-27
 * Description: Main screen of the Product Store app. Displays a scrollable list
 *              of products using RecyclerView. Navigates to DetailActivity when
 *              a product card is tapped.
 */

package com.example.lab02

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * MainActivity is the entry point of the app.
 * Initializes the RecyclerView with a ProductAdapter and handles
 * navigation to DetailActivity on product tap.
 */
class MainActivity : AppCompatActivity() {

    // RecyclerView reference
    private lateinit var recyclerView: RecyclerView

    // Adapter reference
    private lateinit var productAdapter: ProductAdapter

    /**
     * Called when the activity is first created.
     * Sets up the layout, retrieves product data, and configures the RecyclerView.
     *
     * @param savedInstanceState Bundle with previously saved state (null on first launch)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the RecyclerView from layout
        recyclerView = findViewById(R.id.recyclerView)

        // Load product list from the repository
        val products = ProductRepository.getProducts()

        // Create adapter with lambda click handler
        // When a product is clicked, launch DetailActivity with that product
        productAdapter = ProductAdapter(products) { selectedProduct ->
            navigateToDetail(selectedProduct)
        }

        // Apply LinearLayoutManager for vertical scrolling list
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Attach the adapter to the RecyclerView
        recyclerView.adapter = productAdapter
    }

    /**
     * Navigates to DetailActivity, passing the selected product via Intent.
     * Uses Parcelable to bundle the full Product object.
     *
     * @param product The Product object that was tapped by the user
     */
    private fun navigateToDetail(product: Product) {
        // Create an explicit Intent targeting DetailActivity
        val intent = Intent(this, DetailActivity::class.java)

        // Attach the product as a Parcelable extra
        intent.putExtra("PRODUCT_KEY", product)

        // Start the DetailActivity
        startActivity(intent)
    }
}