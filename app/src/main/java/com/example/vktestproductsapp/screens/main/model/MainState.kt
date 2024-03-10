package com.example.vktestproductsapp.screens.main.model

data class MainState (
    val listCategories: List<String> = emptyList(),
    val isCategory: Boolean = false,
    val category: String? = null,
)