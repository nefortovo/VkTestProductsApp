package com.example.backend.models.product

import com.example.backend.models.pagingProduct.PagingProductFullDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    @SerialName("products") val products: List<ProductFullDto>,
    @SerialName("total") val total: Int,
    @SerialName("skip") val skip: Int,
    @SerialName("limit") val limit: Int,
)

