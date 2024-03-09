package com.example.impl.mappers

import com.example.backend.models.product.CategoriesDto
import com.example.base.entities.CategoriesEntity

fun CategoriesDto.asEntity(): CategoriesEntity{
    return CategoriesEntity(
        listCategories = listCategories
    )
}