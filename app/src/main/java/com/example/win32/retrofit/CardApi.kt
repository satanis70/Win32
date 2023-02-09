package com.example.win32.retrofit

import com.example.win32.model.ImagesModel
import retrofit2.Call
import retrofit2.http.GET

interface CardApi {
    @GET("images.json")
    fun getImages(): Call<ImagesModel>
}