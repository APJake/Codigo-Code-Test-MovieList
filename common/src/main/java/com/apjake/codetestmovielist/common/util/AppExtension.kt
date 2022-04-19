package com.apjake.codetestmovielist.common.util

import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide

fun Boolean?.orFalse(): Boolean = this ?: false
fun Double?.orZero(): Double = this?:0.0
fun Int?.orZero(): Int = this?:0

fun Double.toPercentString(): String = "${(this*10)} %"

fun String.fullPosterPath(): String = "http://image.tmdb.org/t/p/w500/${this}"

// Views

fun ImageView.show(imageUrl: String, errorImage: Int) {
    Glide.with(this)
        .load(imageUrl)
        .apply(
            RequestOptions.fitCenterTransform()
                .error(errorImage)
        )
        .into(this)
}