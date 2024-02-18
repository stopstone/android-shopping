package com.stopstone.shoppingapp.data.source.remote

import com.stopstone.shoppingapp.data.model.Product
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ShoppingService {

    @GET("products/{id}.json")
    suspend fun getProduct(@Path("id") id: String): Product


    companion object {
        fun create(): ShoppingService {
            val logger = HttpLoggingInterceptor()
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://shoppingapp-40cb3-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ShoppingService::class.java)
        }
    }
}