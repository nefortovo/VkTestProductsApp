package com.example.base.entities

data class ProductEntity(
    val products: List<ProductFullEntity>,
    val total: Int,
    val skip: Int,
    val limit: Int,
)