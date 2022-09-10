package com.apjake.codetestmovielist.mapper

import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.item.DashboardViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.MovieViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.PopularListViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.TitleViewItem

object DashboardItemMapper {
    private const val POPULAR_VIEW_INDEX = 1
    private const val UPCOMING_VIEW_START_INDEX = 3

    private val moviesMapper = MovieViewItemMapper()

    fun map(
        popularList: List<Movie> = emptyList(),
        upcomingList: List<Movie> = emptyList(),
    ): List<DashboardViewItem> {
        return mapFromViewItems(
            popularList = moviesMapper.map(popularList),
            upcomingList = moviesMapper.map(upcomingList)
        )
    }

    private fun mapFromViewItems(
        popularList: List<MovieViewItem>,
        upcomingList: List<MovieViewItem>,
    ): List<DashboardViewItem> {
        return listOf(
            TitleViewItem(1,"Recommended"),
            PopularListViewItem(2,popularList),
            TitleViewItem(3,"Upcoming Movies"),
        ).plus(upcomingList)
    }

    fun mapPopularMovies(
        items: List<DashboardViewItem>,
        popularList: List<Movie>,
    ): List<DashboardViewItem> {
        val copyList = items.ifEmpty {
            map()
        }.toMutableList()
        copyList[POPULAR_VIEW_INDEX] = PopularListViewItem(2, moviesMapper.map(popularList))
        return copyList
    }

    fun mapUpcomingMovies(
        items: List<DashboardViewItem>,
        upcomingList: List<Movie>,
    ): List<DashboardViewItem> {
        val copyList = items.ifEmpty {
            map()
        }
        return copyList.subList(0, UPCOMING_VIEW_START_INDEX).plus(moviesMapper.map(upcomingList))
    }
}