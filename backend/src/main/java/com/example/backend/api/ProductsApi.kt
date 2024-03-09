package com.example.backend.api

import com.example.backend.models.PagingProductFullDTO
import com.example.backend.models.PagingProductDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {
    @GET("products")
    suspend fun getProducts(
        @Query("limit") limit: Int = 0,
        @Query("skip") skip: Int = 0,
    ): Response<PagingProductDTO>
}