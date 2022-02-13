package com.example.worldskillsprep2022.Repository

import com.example.worldskillsprep2022.api.RetrofitInstance
import com.example.worldskillsprep2022.model.UnsplashResults
import retrofit2.Response

class Repository {

    suspend fun getPhotos(query: String): Response<UnsplashResults>{
        return RetrofitInstance.api.getPhotos(query, "Client-ID ikCLQEB4Rku3ac3thKgITx_qOlrIa7BHhYYHiJIT4Hg")
    }
}