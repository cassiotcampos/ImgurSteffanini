package com.example.imgursteffanini.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imgursteffanini.api.ApiService
import com.example.imgursteffanini.api.GalleryApi

class ViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(GalleryApi(apiService)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}