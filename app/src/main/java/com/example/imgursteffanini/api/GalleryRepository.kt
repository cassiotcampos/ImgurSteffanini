package com.example.imgursteffanini.api

import com.example.imgursteffanini.model.ImgurData

interface GalleryRepository {
    suspend fun getGallery(query : String) : ImgurData
}
