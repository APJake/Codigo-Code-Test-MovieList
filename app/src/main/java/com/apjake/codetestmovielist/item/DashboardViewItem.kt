package com.apjake.codetestmovielist.item

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class DashboardViewItem() {
    class TitleViewItem(
        val id: Int,
        val title: String
    ): DashboardViewItem()
    data class PopularListViewItem(
        val id: Int,
        val movies: List<MovieViewItem>
    ): DashboardViewItem()

    @Parcelize
    data class MovieViewItem(
        val id: Int,
        val title: String,
        val posterPath: String,
        val backdropPath: String,
        val isFavourite: Boolean,
        val rating: String,
        val overview: String
    ) : Parcelable, DashboardViewItem()
}