package com.example.worldskillsprep2022.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UnsplashResults(
    val results: List<UnsplashPhoto>
) : Parcelable{

    @Parcelize
    data class UnsplashPhoto(
        val id: String,
        val description: String?,
        val urls: UnsplashPhotoUrls
    ) : Parcelable{

        @Parcelize
        data class UnsplashPhotoUrls(
            val regular: String
        ) : Parcelable

    }
}