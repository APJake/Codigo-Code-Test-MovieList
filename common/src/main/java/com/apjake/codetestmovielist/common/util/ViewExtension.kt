package com.apjake.codetestmovielist.common.util

import android.widget.ImageView
import com.apjake.codetestmovielist.common.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.show(imageUrl: String) {
    Glide.with(this)
        .load(imageUrl)
        .apply(
            RequestOptions.fitCenterTransform()
                .error(R.drawable.ic_error_outline)
        )
        .into(this)
}