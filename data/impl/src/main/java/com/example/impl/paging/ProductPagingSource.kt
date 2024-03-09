package com.example.impl.paging

import androidx.paging.PagingState
import com.example.backend.api.ProductsApi
import com.example.backend.utils.ResponseStatus
import com.example.base.entities.ProductFullEntity
import com.example.impl.base.BasePagingDataSource
import com.example.impl.mappers.asEntity

class ProductPagingSource(
    private val productsApi: ProductsApi,
    private val initCount: Int = LIMIT,
    private val initPage: Int = PAGE,
): BasePagingDataSource<ProductFullEntity>() {
    override fun getRefreshKey(state: PagingState<Int, ProductFullEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductFullEntity> {

        val pageNumber = params.key ?: initPage
        val pageSize = params.loadSize.coerceAtMost(initCount)
        val skip = pageNumber * pageSize
        val resp = safeApiSuspendResult {
            productsApi.getProducts(
                skip = skip,
                limit = pageSize,
            )
        }
        /**
         * total 100
         * skip 0
         * pageSize 20
         */

        when (resp) {
            is ResponseStatus.Success -> {
                resp.data?.let { data ->
                    val nextKey = if (skip > data.total - pageSize) null else pageNumber + 1
                    val prevKey = if (pageNumber < 1) null else pageNumber - 1
                    return LoadResult.Page(
                        data = data.products.map { it.asEntity() },
                        nextKey = nextKey,
                        prevKey = prevKey,
                    )
                } ?: run {
                    return LoadResult.Error(NullPointerException("PagingSourceOrdersHistory got null data"))
                }
            }

            is ResponseStatus.Error -> {
                return LoadResult.Error(Exception(resp.exception.message))
            }

            else -> {
                return LoadResult.Error(Exception("BOG POMOJET"))
            }
        }

    }
}