package com.example.retrofittestapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface JsonPlaceHolderApi {
    @GET("posts")
    fun getMemberList(): Call<JsonDto>

    @GET("posts/{postId}")
    fun postMemberList(@Path("postId") postId: Int): Call<JsonDto>
}