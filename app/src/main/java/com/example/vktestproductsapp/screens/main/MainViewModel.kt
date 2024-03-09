package com.example.vktestproductsapp.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.base.entities.ProductEntity
import com.example.base.repositories.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    productsRepository: ProductsRepository
): ViewModel() {

    private var _productList: Flow<PagingData<ProductEntity>> =
        productsRepository.getProducts()
    val productList: Flow<PagingData<ProductEntity>> = _productList.cachedIn(viewModelScope)

}