package com.example.backend.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagingProductDTO(
    @SerialName("products") val products: List<PagingProductFullDTO>,
    @SerialName("total") val total: Int,
    @SerialName("skip") val skip: Int,
    @SerialName("limit") val limit: Int,
)
