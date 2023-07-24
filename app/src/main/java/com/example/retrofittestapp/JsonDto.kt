package com.example.retrofittestapp


import com.squareup.moshi.Json

class JsonDto : ArrayList<JsonDto.JsonDtoItem>(){
    data class JsonDtoItem(
        @Json(name = "body")
        val body: String?,
        @Json(name = "id")
        val id: Int?,
        @Json(name = "title")
        val title: String?,
        @Json(name = "userId")
        val userId: Int?
    )
}