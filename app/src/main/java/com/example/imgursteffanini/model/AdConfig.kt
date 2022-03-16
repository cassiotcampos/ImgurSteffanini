package com.example.imgursteffanini.model

import com.google.gson.annotations.SerializedName


data class AdConfig (

  @SerializedName("safeFlags"       ) var safeFlags       : ArrayList<String> = arrayListOf(),
  @SerializedName("highRiskFlags"   ) var highRiskFlags   : ArrayList<String> = arrayListOf(),
  @SerializedName("unsafeFlags"     ) var unsafeFlags     : ArrayList<String> = arrayListOf(),
  @SerializedName("wallUnsafeFlags" ) var wallUnsafeFlags : ArrayList<String> = arrayListOf(),
  @SerializedName("showsAds"        ) var showsAds        : Boolean?          = null

)