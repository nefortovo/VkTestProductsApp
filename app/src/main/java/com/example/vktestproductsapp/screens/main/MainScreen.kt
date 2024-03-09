package com.example.vktestproductsapp.screens.main

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import com.example.vktestproductsapp.uicomponents.listItems.CategoriesItem
import com.example.vktestproductsapp.uicomponents.listItems.ProductItem
import com.example.vktestproductsapp.uicomponents.skeleton.SkeletonWithContent

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navigateToProduct: (Int) -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    val productList = viewModel.productList.collectAsLazyPagingItems()

    val uiState by viewModel.uiState.collectAsState()


    LaunchedEffect(Unit){
        viewModel.getCategories()
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
//        LazyVerticalGrid(columns = GridCells.Fixed(2),
//            modifier = Modifier
//                .padding(horizontal = 13.dp)){
//            items(productList){
//                product ->
//                SkeletonWithContent(showSkeleton = product == null,
//                    modifier = Modifier
//                        .fillMaxSize()) {
//                    ProductItem(modifier = Modifier
//                        .clickable { product?.id?.let { navigateToProduct(it) } }
//                        .padding(top = 15.dp)
//                        .padding(horizontal = 5.dp), product = product!!,)
//                }
//            }
//        }

        LazyRow(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 30.dp)
        ){
            items(items = uiState.listCategories){item ->
                CategoriesItem(category = item,
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .clickable{

                        }
                )
            }
        }




        LazyColumn(
            modifier = Modifier.
            padding(top = 20.dp)
        ){
            items(productList){ product ->
                SkeletonWithContent(showSkeleton = product == null,
                    modifier = Modifier
                        .fillMaxSize()) {
                    ProductItem(modifier = Modifier
                        .clickable { product?.id?.let { navigateToProduct(it) } }
                        .padding(top = 15.dp)
                        .padding(horizontal = 35.dp), product = product!!,)
                }
            }
        }
    }
}





