package com.example.vktestproductsapp.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navigateToProduct: (String) -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    val productList = viewModel.productList.collectAsLazyPagingItems()

    Column {
        LazyColumn(){
            items(productList){
                product ->
                product?.title?.let { Text(text = it) }
            }
        }
    }
}


