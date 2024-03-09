package com.example.base.entities

data class ProductFullEntity (
    val id: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val price: Int? = 0,
    val discountPercentage: Double? = 0.0,
    val rating: Double? = 0.0,
    val stock: Int? = null,
    val brand: String? = null,
    val category: String? = null,
    val thumbnail: String? = null,
    val images: List<String>? = emptyList(),
)