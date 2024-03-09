package com.example.backend.models.product

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductFullDto (
    @SerialName("id") val id: Int? = null,
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