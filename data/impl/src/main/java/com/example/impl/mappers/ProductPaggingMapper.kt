package com.example.impl.mappers


import com.example.backend.models.pagingProduct.PagingProductFullDTO
import com.example.base.entities.ProductFullEntity

fun PagingProductFullDTO.asEntity(): ProductFullEntity {
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