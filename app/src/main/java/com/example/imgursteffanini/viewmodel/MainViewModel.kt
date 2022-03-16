package com.example.imgursteffanini.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.imgursteffanini.api.GalleryRepository
import com.example.imgursteffanini.api.Resource
import com.example.imgursteffanini.model.Data
import com.example.imgursteffanini.model.ImgurData
import com.example.imgursteffanini.util.createCoverJpgUrl
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repository: GalleryRepository) : ViewModel() {

    private val _showLoading = MutableLiveData<Boolean>()

    // List of selected options for each step / OrderData
    private val _galleryCats = MutableLiveData<ImgurData>()

    init {

    }

    // api calls (avoid to call again on onResume)
    private var imgurData: ImgurData? = null
    fun getCats() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        if (imgurData == null) {
            try {
                imgurData = repository.getGallery("cats")

                imgurData = removeInvalidCovers(imgurData)

                emit(Resource.success(data = imgurData))
            } catch (exception: Exception) {
                emit(
                    Resource.error(
                        data = null,
                        message = exception.message ?: Resource.ERROR_MSG_DEFAULT
                    )
                )
            }
        } else {
            emit(Resource.success(data = imgurData))
        }
    }

    private fun removeInvalidCovers(imgurData: ImgurData?) : ImgurData?{
        imgurData?.data?.iterator()?.let {
            val listWithValidCover = arrayListOf<Data>()
            for (data in it) {
                if(!data.cover.isNullOrEmpty()) {
                    listWithValidCover.add(data)
                }
            }
            imgurData.data = listWithValidCover
        }
        return imgurData
    }

    fun setLoading(boolean: Boolean) {
        _showLoading.postValue(boolean)
    }
}