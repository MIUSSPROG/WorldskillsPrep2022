package com.example.worldskillsprep2022.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldskillsprep2022.Repository.Repository
import com.example.worldskillsprep2022.model.UnsplashResults
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(): ViewModel() {

    val myResponse: MutableLiveData<Response<UnsplashResults>> = MutableLiveData()

    fun getPhotos(query: String){
        viewModelScope.launch {
            val response = repository.getPhotos(query)
            myResponse.postValue(response)
        }
    }

    companion object{
        val repository = Repository()
    }

}