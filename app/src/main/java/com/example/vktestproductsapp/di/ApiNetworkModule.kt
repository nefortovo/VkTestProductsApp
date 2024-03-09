package com.example.vktestproductsapp.di

import com.example.backend.api.ProductsApi
import com.example.impl.providers.NetworkProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BackendProducts

@Module
@InstallIn(SingletonComponent::class)
class ApiNetworkModule {

    @Provides
    @BackendProducts
    fun provideBaseUrl(): String = "https://dummyjson.com/"

    @Provides
    @Singleton
    fun provideNetworkProvider(
        @BackendProducts host : String
    ): NetworkProvider = NetworkProvider(
        host,
    )

    @Provides
    fun provideProductApi(
        provider: NetworkProvider
    )  = provider.provideRetrofit(ProductsApi::class.java)

}