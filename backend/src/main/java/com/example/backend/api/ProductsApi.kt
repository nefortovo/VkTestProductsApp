package com.example.backend.api

import com.example.backend.models.pagingProduct.PagingProductDTO
import com.example.backend.models.product.ProductFullDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductsApi {
    @GET("products")
    suspend fun getProducts(
        @Query("limit") limit: Int = 0,
        @Query("skip") skip: Int = 0,
    ): Response<PagingProductDTO>

    @GET("products/{id}")
    suspend fun getProduct(
        @Path("id") id: Int
    ): Response<ProductFullDto>

    @GET("products/categories")
    suspend fun getCategories(
    ): Response<List<String>>


}