package com.example.impl.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.backend.api.ProductsApi
import com.example.base.entities.ProductEntity
import com.example.base.repositories.ProductsRepository
import com.example.impl.base.BasePagingDataSource
import com.example.impl.base.BaseRepository
import com.example.impl.paging.ProductPagingSource
import kotlinx.coroutines.flow.Flow

class ProductsRepositoryImpl(
    private val productsApi: ProductsApi
): ProductsRepository, BaseRepository(ProductsRepository::class.toString()) {
    override fun getProducts(): Flow<PagingData<ProductEntity>>
    {
        return Pager(
            config = PagingConfig(
                pageSize = BasePagingDataSource.LIMIT,
                initialLoadSize = 10
            ),
            pagingSourceFactory = {
                ProductPagingSource(
                    productsApi = productsApi,
                )
            }
        ).flow
    }

}