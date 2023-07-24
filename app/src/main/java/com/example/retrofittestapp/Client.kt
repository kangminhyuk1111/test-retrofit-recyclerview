package com.example.retrofittestapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    val BASE_URL = "https://jsonplaceholder.typicode.com/"
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    val api: JsonPlaceHolderApi by lazy { retrofit.create(JsonPlaceHolderApi::class.java) }
}