package com.example.worldskillsprep2022.api

import com.example.worldskillsprep2022.model.UnsplashResults
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("search/photos")
    suspend fun getPhotos(@Query("query") query: String, @Header("Authorization") token: String) : Response<UnsplashResults>
}