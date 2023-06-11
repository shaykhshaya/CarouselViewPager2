package com.shaya.carouselviewpager.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageEntity(
    val title: String? = null,
    val description: String? = null,
    val image: Int
):Parcelable
