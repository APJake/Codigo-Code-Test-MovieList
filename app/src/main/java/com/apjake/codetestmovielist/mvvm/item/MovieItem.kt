package com.apjake.codetestmovielist.mvvm.item

data class MovieItem(
    val id: Int,
    val title: String,
    val posterPath: String,
    val isFavourite: Boolean,
    val rating: String,
    val overview: String
)
