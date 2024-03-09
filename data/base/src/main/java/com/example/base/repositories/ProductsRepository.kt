package com.example.base.repositories

import androidx.paging.PagingData
import com.example.base.entities.Entity
import com.example.base.entities.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProducts(): Flow<PagingData<ProductEntity>>
}