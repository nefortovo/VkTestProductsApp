package com.example.vktestproductsapp.screens.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.entities.Entity
import com.example.base.repositories.ProductsRepository
import com.example.vktestproductsapp.screens.product.model.ProductUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(ProductUIState())
    val uiState = _uiState.asStateFlow()

    suspend fun getData(id: Int){
        viewModelScope.launch {
            when (val response = productsRepository.getProduct(id)) {
                is Entity.Success -> {
                    _uiState.update { uiState ->
                        uiState.copy(
                            productFullEntity = response.data
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