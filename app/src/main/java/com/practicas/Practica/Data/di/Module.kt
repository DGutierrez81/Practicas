package com.practicas.Practica.Data.di

import com.practicas.Practica.Data.util.Constans.Companion.BASE_URL
import com.practicas.Practica.Data.ItemInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun Retrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideItemApiService(retrofit: Retrofit): ItemInterface {
        return retrofit.create(ItemInterface::class.java )
    }
}