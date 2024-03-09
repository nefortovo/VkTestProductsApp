package com.example.impl.mappers

import com.example.backend.models.product.ProductDto
import com.example.backend.models.product.ProductFullDto
import com.example.base.entities.ProductEntity
import com.example.base.entities.ProductFullEntity

fun ProductDto.asEntity(): ProductEntity {
    return ProductEntity(
        products = products.map { it.asEntity() },
        total = total,
        skip = skip,
        limit = limit,
    )
}


fun ProductFullDto.asEntity(): ProductFullEntity {
    return ProductFullEntity(
        id = id,
        title = title,
        description = description,
        price = price,
        discountPercentage = discountPercentage,
        rating = rating,
        stock = stock,
        brand = brand,
        category = category,
        thumbnail = thumbnail,
        images = images,
    )
}