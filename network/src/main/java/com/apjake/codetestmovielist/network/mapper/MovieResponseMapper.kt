package com.apjake.codetestmovielist.network.mapper

import com.apjake.codetestmovielist.common.util.UniMapper
import com.apjake.codetestmovielist.common.util.orFalse
import com.apjake.codetestmovielist.common.util.orZero
import com.apjake.codetestmovielist.domain.models.MovieVO
import com.apjake.codetestmovielist.network.response.Movie
import javax.inject.Inject

class MovieResponseMapper @Inject constructor(): UniMapper<List<Movie>?, List<MovieVO>> {
    override fun map(data: List<Movie>?): List<MovieVO> {
        return data?.map { m ->
            MovieVO(
                adult = m.adult.orFalse(),
                backdrop_path = m.backdrop_path.orEmpty(),
                genre_ids = m.genre_ids.orEmpty(),
                id = m.id,
                original_language = m.original_language.orEmpty(),
                original_title = m.original_title.orEmpty(),
                overview = m.overview.orEmpty(),
                popularity = m.popularity.orZero(),
                poster_path = m.poster_path.orEmpty(),
                release_date = m.release_date.orEmpty(),
                title = m.title.orEmpty(),
                video = m.video.orFalse(),
                vote_average = m.vote_average.orZero(),
                vote_count = m.vote_count.orZero(),
                isFavourite = false
            )
        }.orEmpty()
    }
}