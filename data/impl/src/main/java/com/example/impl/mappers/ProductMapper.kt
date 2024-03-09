package com.example.impl.mappers


import com.example.backend.models.PagingProductFullDTO
import com.example.base.entities.ProductEntity

fun PagingProductFullDTO.asEntity(): ProductEntity {
    return ProductEntity(
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