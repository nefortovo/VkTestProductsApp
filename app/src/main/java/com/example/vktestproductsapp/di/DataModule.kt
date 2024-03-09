package com.example.vktestproductsapp.di

import com.example.backend.api.ProductsApi
import com.example.base.repositories.ProductsRepository
import com.example.impl.repositories.ProductsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideProductRepository(
        productsApi: ProductsApi
    ): ProductsRepository = ProductsRepositoryImpl(
        productsApi = productsApi
    )
}