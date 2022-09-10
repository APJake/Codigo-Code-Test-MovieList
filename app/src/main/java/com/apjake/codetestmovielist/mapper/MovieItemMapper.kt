package com.apjake.codetestmovielist.mapper

import com.apjake.codetestmovielist.common.util.UniMapper
import com.apjake.codetestmovielist.common.util.fullPosterPath
import com.apjake.codetestmovielist.common.util.toPercentString
import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.item.DashboardViewItem.MovieViewItem
import javax.inject.Inject

class MovieViewItemMapper @Inject constructor(): UniMapper<List<Movie>, List<MovieViewItem>> {
    override fun map(data: List<Movie>): List<MovieViewItem> {
        return data.map { m ->
            MovieViewItem(
                id = m.id,
                title = m.title,
                posterPath =  m.posterPath.fullPosterPath(),
                isFavourite = m.isFavourite,
                rating = m.voteAverage.toPercentString(),
                overview = m.overview,
                backdropPath = m.backdropPath.fullPosterPath()
            )
        }
    }

}