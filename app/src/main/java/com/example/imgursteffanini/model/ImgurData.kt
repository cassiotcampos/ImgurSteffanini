package com.example.imgursteffanini.model

import com.google.gson.annotations.SerializedName


data class ImgurData (

  @SerializedName("data"    ) var data    : ArrayList<Data> = arrayListOf(),
  @SerializedName("success" ) var success : Boolean?        = null,
  @SerializedName("status"  ) var status  : Int?            = null

)