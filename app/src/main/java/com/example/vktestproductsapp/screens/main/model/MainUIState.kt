package com.example.vktestproductsapp.screens.main.model

import com.example.base.entities.CategoriesEntity

data class MainUIState (
    val listCategories: List<String> = emptyList(),
    val isCategory: Boolean = false,
    val category: String? = null,
)