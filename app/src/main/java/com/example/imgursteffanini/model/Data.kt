package com.example.imgursteffanini.model
import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("id"             ) var id            : String?         = null,
  @SerializedName("title"          ) var title         : String?         = null,
  @SerializedName("description"    ) var description   : String?         = null,
  @SerializedName("datetime"       ) var datetime      : Int?            = null,
  @SerializedName("type"           ) var type          : String?         = null,
  @SerializedName("animated"       ) var animated      : Boolean?        = null,
  @SerializedName("width"          ) var width         : Int?            = null,
  @SerializedName("height"         ) var height        : Int?            = null,
  @SerializedName("size"           ) var size          : Int?            = null,
  @SerializedName("views"          ) var views         : Int?            = null,
  @SerializedName("is_album"       ) var isAlbum       : Boolean?        = null,
  @SerializedName("cover"          ) var cover         : String?         = null

)