package com.example.backend.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * "id": 1,
 *     "title": "iPhone 9",
 *     "description": "An apple mobile which is nothing like apple",
 *     "price": 549,
 *     "discountPercentage": 12.96,
 *     "rating": 4.69,
 *     "stock": 94,
 *     "brand": "Apple",
 *     "category": "smartphones",
 *     "thumbnail": "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
 *     "images": [
 *         "https://cdn.dummyjson.com/product-images/1/1.jpg",
 *         "https://cdn.dummyjson.com/product-images/1/2.jpg",
 *         "https://cdn.dummyjson.com/product-images/1/3.jpg",
 *         "https://cdn.dummyjson.com/product-images/1/4.jpg",
 *         "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
 *     ]
 */
@Serializable
data class PagingProductFullDTO (
     @SerialName("title") val title: String? = null,
     @SerialName("description") val description: String? = null,
     @SerialName("price") val price: Int? = 0,
     @SerialName("discountPercentage") val discountPercentage: Double? = 0.0,
     @SerialName("rating") val rating: Double? = 0.0,
     @SerialName("stock") val stock: Int? = null,
     @SerialName("brand") val brand: String? = null,
     @SerialName("category") val category: String? = null,
     @SerialName("thumbnail") val thumbnail: String? = null,
     @SerialName("images") val images: List<String>? = emptyList(),
)
