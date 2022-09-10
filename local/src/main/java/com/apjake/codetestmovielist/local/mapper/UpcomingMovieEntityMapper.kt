package com.apjake.codetestmovielist.local.mapper

import com.apjake.codetestmovielist.common.util.BiMapper
import com.apjake.codetestmovielist.common.util.UniMapper
import com.apjake.codetestmovielist.common.util.orFalse
import com.apjake.codetestmovielist.common.util.orZero
import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.local.entity.UpcomingMovieEntity
import javax.inject.Inject

class UpcomingMovieEntityMapper @Inject constructor(): BiMapper<UpcomingMovieEntity, Movie> {
    override fun map(data: UpcomingMovieEntity): Movie {
        return with(data){
            Movie(
                id = id,
                title = title.orEmpty(),
                adult = adult.orFalse(),
                backdropPath = backdropPath.orEmpty(),
                genreIds = genreIds.orEmpty(),
                originalTitle = originalTitle.orEmpty(),
                originalLanguage = originalLanguage.orEmpty(),
                overview = overview.orEmpty(),
                popularity = popularity.orZero(),
                posterPath = posterPath.orEmpty(),
                releaseDate = releaseDate.orEmpty(),
                video = video.orFalse(),
                voteAverage = voteAverage.orZero(),
                voteCount = voteCount.orZero(),
                isFavourite = isFavourite.orFalse()
            )
        }
    }

    override fun mapReverse(data: Movie): UpcomingMovieEntity {
        return with(data){
            UpcomingMovieEntity(
                id = id,
                title = title,
                adult = adult,
                backdropPath = backdropPath,
                genreIds = genreIds,
                originalTitle = originalTitle,
                originalLanguage = originalLanguage,
                overview = overview,
                popularity = popularity,
                posterPath = posterPath,
                releaseDate = releaseDate,
                video = video,
                voteAverage = voteAverage,
                voteCount = voteCount,
                isFavourite = isFavourite,
            )
        }
    }

}