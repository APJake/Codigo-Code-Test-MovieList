package com.apjake.codetestmovielist.local.mapper

import com.apjake.codetestmovielist.common.util.UniMapper
import com.apjake.codetestmovielist.common.util.orFalse
import com.apjake.codetestmovielist.common.util.orZero
import com.apjake.codetestmovielist.domain.models.MovieVO
import com.apjake.codetestmovielist.local.entity.UpcomingMovieEntity
import javax.inject.Inject

class UpcomingMovieEntityMapper @Inject constructor(): UniMapper<List<UpcomingMovieEntity>, List<MovieVO>> {
    override fun map(data: List<UpcomingMovieEntity>): List<MovieVO> {
        return data.map { m ->
            MovieVO(
                id = m.id,
                title = m.title.orEmpty(),
                adult = m.adult.orFalse(),
                backdrop_path = m.backdrop_path.orEmpty(),
                genre_ids = m.genre_ids.orEmpty(),
                original_title = m.original_title.orEmpty(),
                original_language = m.original_language.orEmpty(),
                overview = m.overview.orEmpty(),
                popularity = m.popularity.orZero(),
                poster_path = m.poster_path.orEmpty(),
                release_date = m.release_date.orEmpty(),
                video = m.video.orFalse(),
                vote_average = m.vote_average.orZero(),
                vote_count = m.vote_count.orZero(),
                isFavourite = m.isFavourite.orFalse()
            )
        }
    }

    fun mapToEntity(data: List<MovieVO>): List<UpcomingMovieEntity>{
        return data.map{ m ->
            UpcomingMovieEntity(
                id = m.id,
                title = m.title,
                adult = m.adult,
                backdrop_path = m.backdrop_path,
                genre_ids = m.genre_ids,
                original_title = m.original_title,
                original_language = m.original_language,
                overview = m.overview,
                popularity = m.popularity,
                poster_path = m.poster_path,
                release_date = m.release_date,
                video = m.video,
                vote_average = m.vote_average,
                vote_count = m.vote_count,
                isFavourite = m.isFavourite,
            )
        }
    }

}