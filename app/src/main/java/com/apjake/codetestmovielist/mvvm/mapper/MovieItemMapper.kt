package com.apjake.codetestmovielist.mvvm.mapper

import com.apjake.codetestmovielist.common.util.UniMapper
import com.apjake.codetestmovielist.common.util.fullPosterPath
import com.apjake.codetestmovielist.common.util.toPercentString
import com.apjake.codetestmovielist.domain.models.MovieVO
import com.apjake.codetestmovielist.mvvm.item.MovieItem

class MovieItemMapper: UniMapper<List<MovieVO>, List<MovieItem>> {
    override fun map(data: List<MovieVO>): List<MovieItem> {
        return data.map { m ->
            MovieItem(
                id = m.id,
                title = m.title,
                posterPath =  m.poster_path.fullPosterPath(),
                isFavourite = m.isFavourite,
                rating = m.vote_average.toPercentString(),
                overview = m.overview
            )
        }
    }

}