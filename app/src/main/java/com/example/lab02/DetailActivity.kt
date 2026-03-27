/**
 * Course: MAD302 - Mobile Application Development
 * Lab: Lab 02 - RecyclerView & Navigation
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date: 2026-03-27
 * Description: Detail screen that receives a Product object via Intent and
 *              displays its full information including name, category, price,
 *              rating, and description. Uses null safety when reading Intent data.
 */

package com.example.lab02

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * DetailActivity displays the full details of a selected product.
 * It retrieves the Product object passed from MainActivity via Intent extras,
 * applies null safety, and populates all TextViews accordingly.
 */
class DetailActivity : AppCompatActivity() {

    /**
     * Called when the activity is created.
     * Reads the Product from the Intent, checks for null, and populates the UI.
     *
     * @param savedInstanceState Previously saved state bundle (null on first launch)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // --- Retrieve views ---
        val tvName = findViewById<TextView>(R.id.tvDetailName)
        val tvCategory = findViewById<TextView>(R.id.tvDetailCategory)
        val tvPrice = findViewById<TextView>(R.id.tvDetailPrice)
        val tvRating = findViewById<TextView>(R.id.tvDetailRating)
        val tvDescription = findViewById<TextView>(R.id.tvDetailDescription)
        val btnBack = findViewById<TextView>(R.id.btnBack)

        // --- Null-safe retrieval of the Product from the Intent ---
        // getParcelableExtra can return null if the key is missing or data is corrupt
        val product: Product? = intent.getParcelableExtra("PRODUCT_KEY")

        if (product != null) {
            // Product data is valid — populate all fields
            populateUI(
                product = product,
                tvName = tvName,
                tvCategory = tvCategory,
                tvPrice = tvPrice,
                tvRating = tvRating,
                tvDescription = tvDescription
            )
        } else {
            // Null safety fallback — show error and go back
            Toast.makeText(this, "Error: Product data not found.", Toast.LENGTH_LONG).show()
            finish() // close this activity and return to list
        }

        // Back button click — finish this activity and return to MainActivity
        btnBack.setOnClickListener {
            finish()
        }
    }

    /**
     * Populates all TextViews on the detail screen with the product's data.
     *
     * @param product The Product whose details are to be displayed
     * @param tvName TextView for the product name
     * @param tvCategory TextView for the category badge
     * @param tvPrice TextView for the formatted price
     * @param tvRating TextView for the star rating
     * @param tvDescription TextView for the full description
     */
    private fun populateUI(
        product: Product,
        tvName: TextView,
        tvCategory: TextView,
        tvPrice: TextView,
        tvRating: TextView,
        tvDescription: TextView
    ) {
        tvName.text = product.name
        tvCategory.text = product.category

        // Format price to 2 decimal places with dollar sign
        tvPrice.text = "$${String.format("%.2f", product.price)}"

        // Build rating string with stars
        tvRating.text = "★ ${product.rating} / 5.0"

        tvDescription.text = product.description
    }
}