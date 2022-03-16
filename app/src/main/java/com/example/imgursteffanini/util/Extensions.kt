package com.example.imgursteffanini.util

import android.app.Activity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.imgursteffanini.model.Data

fun ImageView.loadUrlWithCrop(url: String?) {
    val glide = when (context) {
        is Activity -> Glide.with(context as Activity)
        else -> Glide.with(context)
    }

    glide.load(url).centerCrop().into(this)
}

fun Data.createCoverJpgUrl(coverHash : String) : String {
    return "https://i.imgur.com/" +
            coverHash + ".jpg"
}