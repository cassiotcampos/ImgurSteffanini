package com.example.imgursteffanini.api

import com.example.imgursteffanini.model.ImgurData


class GalleryApi (private val apiService: ApiService): GalleryRepository {
    override suspend fun getGallery(query : String): ImgurData {
        return apiService.getGallery(query)
    }
}