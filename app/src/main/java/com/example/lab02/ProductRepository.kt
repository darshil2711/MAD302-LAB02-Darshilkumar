/**
 * Course: MAD302 - Mobile Application Development
 * Lab: Lab 02 - RecyclerView & Navigation
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date: 2026-03-27
 * Description: Provides a static list of sample products for the app.
 */

package com.example.lab02

/**
 * Repository object that supplies the product data list.
 * Acts as a local data source for this lab (no network/database needed).
 */
object ProductRepository {

    /**
     * Returns a list of 8 sample products.
     * Each product has an id, name, price, description, category, and rating.
     *
     * @return List of Product objects
     */
    fun getProducts(): List<Product> = listOf(
        Product(
            id = 1,
            name = "Sony WH-1000XM5",
            price = 349.99,
            description = "Industry-leading noise cancelling headphones with up to 30 hours battery life. Features multipoint connection and crystal clear hands-free calling.",
            category = "Electronics",
            rating = 4.8f
        ),
        Product(
            id = 2,
            name = "Samsung Galaxy Tab S9",
            price = 699.99,
            description = "Flagship Android tablet with a stunning 11-inch AMOLED display, Snapdragon 8 Gen 2 processor, and S Pen included for creativity on the go.",
            category = "Electronics",
            rating = 4.6f
        ),
        Product(
            id = 3,
            name = "Nike Air Max 270",
            price = 129.99,
            description = "Lifestyle sneaker with the tallest Air unit heel for maximum comfort. Features a breathable mesh upper and foam midsole for all-day wear.",
            category = "Footwear",
            rating = 4.5f
        ),
        Product(
            id = 4,
            name = "Instant Pot Duo 7-in-1",
            price = 89.99,
            description = "Multi-use pressure cooker that replaces 7 kitchen appliances. Cooks up to 70% faster than traditional methods. 6-quart capacity.",
            category = "Kitchen",
            rating = 4.7f
        ),
        Product(
            id = 5,
            name = "Kindle Paperwhite",
            price = 139.99,
            description = "Waterproof e-reader with a 6.8-inch glare-free display, adjustable warm light, and weeks of battery life. Holds thousands of books.",
            category = "Electronics",
            rating = 4.6f
        ),
        Product(
            id = 6,
            name = "Levi's 511 Slim Jeans",
            price = 59.99,
            description = "Classic slim-fit jeans made with flexible fabric for comfort and style. Sits below waist with a slim leg from hip to ankle.",
            category = "Clothing",
            rating = 4.4f
        ),
        Product(
            id = 7,
            name = "Vitamix E310 Blender",
            price = 349.99,
            description = "Professional-grade blender with a 48-oz container, 10 variable speed settings, and self-cleaning mode. Handles hot soups to frozen desserts.",
            category = "Kitchen",
            rating = 4.9f
        ),
        Product(
            id = 8,
            name = "Moleskine Classic Notebook",
            price = 24.99,
            description = "Iconic hardcover notebook with 240 pages of ivory paper. Features a ribbon bookmark, elastic closure, and expandable inner pocket.",
            category = "Stationery",
            rating = 4.5f
        )
    )
}