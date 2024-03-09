package com.example.base.repositories

import androidx.paging.PagingData
import com.example.base.entities.Entity
import com.example.base.entities.ProductFullEntity
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {



    fun getCategoryProducts(): Flow<PagingData<ProductFullEntity>>

    suspend fun getProduct(id: Int): Entity<ProductFullEntity>
    suspend fun getCategories(): Entity<List<String>>
}