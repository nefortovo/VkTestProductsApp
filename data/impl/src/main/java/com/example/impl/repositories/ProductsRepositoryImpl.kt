package com.example.impl.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.backend.api.ProductsApi
import com.example.backend.utils.ResponseStatus
import com.example.base.entities.Entity
import com.example.base.entities.ProductFullEntity
import com.example.base.repositories.ProductsRepository
import com.example.impl.base.BasePagingDataSource
import com.example.impl.base.BaseRepository
import com.example.impl.mappers.asEntity
import com.example.impl.paging.ProductPagingSource
import kotlinx.coroutines.flow.Flow

class ProductsRepositoryImpl(
    private val productsApi: ProductsApi
): ProductsRepository, BaseRepository(ProductsRepository::class.toString()) {
    override fun getProducts(): Flow<PagingData<ProductFullEntity>>
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




    override suspend fun getProduct(id: Int): Entity<ProductFullEntity> {
        return when (val response = safeApiSuspendResult {
            productsApi.getProduct(id)
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it.asEntity()
                    }
                } ?: kotlin.run {
                    Entity.Error(
                        "Ошибка парсинга информации пользователя"
                    )
                }
            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }
        }
    }

    override suspend fun getCategories(): Entity<List<String>> {
        return when (val response = safeApiSuspendResult {
            productsApi.getCategories()
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it
                    }
                } ?: kotlin.run {
                    Entity.Error(
                        "Ошибка парсинга информации пользователя"
                    )
                }
            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }
        }
    }
}