package com.example.vktestproductsapp.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.base.entities.Entity
import com.example.base.entities.ProductFullEntity
import com.example.base.repositories.ProductsRepository
import com.example.vktestproductsapp.screens.main.model.MainUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(MainUIState())
    val uiState = _uiState.asStateFlow()

    private var _productList: Flow<PagingData<ProductFullEntity>> =
        productsRepository.getCategoryProducts()
    val productList: Flow<PagingData<ProductFullEntity>> = _productList.cachedIn(viewModelScope)

    suspend fun getCategories(){
        viewModelScope.launch {
            when (val response = productsRepository.getCategories()) {
                is Entity.Success -> {
                    _uiState.update { uiState ->
                        uiState.copy(
                            listCategories = response.data
                        )
                    }
                }

                is Entity.Error -> {

                }

                else -> {

                }
            }
        }
    }

}