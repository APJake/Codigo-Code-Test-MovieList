package com.apjake.codetestmovielist.features.movies.list

import com.apjake.codetestmovielist.item.DashboardViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.MovieViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.PopularListViewItem
import com.apjake.codetestmovielist.mapper.DashboardItemMapper

data class HomeUiState(
    val isLoading: Boolean = false,
    val dashboardItems: List<DashboardViewItem> = DashboardItemMapper.map()
)