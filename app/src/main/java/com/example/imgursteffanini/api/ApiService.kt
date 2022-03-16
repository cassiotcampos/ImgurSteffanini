package com.example.imgursteffanini.api


import com.example.imgursteffanini.model.ImgurData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers("Authorization: Client-ID 1ceddedc03a5d71")
    @GET("/3/gallery/search/")
    suspend fun getGallery(@Query("q") q: String): ImgurData
}