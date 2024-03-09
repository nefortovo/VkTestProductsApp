package com.example.backend.models.product

import kotlinx.serialization.Serializable

@Serializable
data class CategoriesDto (
    val listCategories: List<String>
)