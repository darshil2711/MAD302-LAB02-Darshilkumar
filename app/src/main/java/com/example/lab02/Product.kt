/**
 * Course: MAD302 - Mobile Application Development
 * Lab: Lab 02 - RecyclerView & Navigation
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date: 2026-03-27
 * Description: Data model class representing a Product with Parcelable support
 *              for passing between activities via Intent.
 */

package com.example.lab02

import android.os.Parcel
import android.os.Parcelable

/**
 * Product data model class.
 * Implements Parcelable so instances can be passed between activities using Intent.
 *
 * @property id Unique identifier for the product
 * @property name Display name of the product
 * @property price Price of the product as a Double
 * @property description Full description of the product
 * @property category Category label (e.g., "Electronics")
 * @property rating Rating out of 5.0
 */
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val category: String,
    val rating: Float
) : Parcelable {

    /**
     * Constructor used by Parcelable to recreate the object from a Parcel.
     * @param parcel The Parcel containing the product data
     */
    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        name = parcel.readString() ?: "",       // null safety with Elvis operator
        price = parcel.readDouble(),
        description = parcel.readString() ?: "",
        category = parcel.readString() ?: "",
        rating = parcel.readFloat()
    )

    /**
     * Writes the product's properties into the Parcel for transmission.
     * @param parcel Destination Parcel
     * @param flags Additional flags (unused here)
     */
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeDouble(price)
        parcel.writeString(description)
        parcel.writeString(category)
        parcel.writeFloat(rating)
    }

    /**
     * Describes special objects in this Parcelable (none here).
     * @return 0 since no special objects are included
     */
    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Product> {

        /**
         * Creates a Product from a Parcel.
         * @param parcel Source parcel
         * @return Reconstructed Product object
         */
        override fun createFromParcel(parcel: Parcel): Product = Product(parcel)

        /**
         * Creates an empty Product array of the specified size.
         * @param size Number of elements in the array
         * @return Array of nulls typed as Product
         */
        override fun newArray(size: Int): Array<Product?> = arrayOfNulls(size)
    }
}