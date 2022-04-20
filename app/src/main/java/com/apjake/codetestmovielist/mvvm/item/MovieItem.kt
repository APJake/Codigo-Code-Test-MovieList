package com.apjake.codetestmovielist.mvvm.item

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieItem(
    val id: Int,
    val title: String,
    val posterPath: String,
    val isFavourite: Boolean,
    val rating: String,
    val overview: String
) : Parcelable
