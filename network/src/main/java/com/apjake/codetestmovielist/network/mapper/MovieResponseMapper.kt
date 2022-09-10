package com.apjake.codetestmovielist.network.mapper

import com.apjake.codetestmovielist.common.util.UniMapper
import com.apjake.codetestmovielist.common.util.orFalse
import com.apjake.codetestmovielist.common.util.orZero
import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.network.response.MovieListResponse
import javax.inject.Inject

class MovieResponseMapper @Inject constructor(): UniMapper<MovieListResponse, List<Movie>> {
    override fun map(data: MovieListResponse): List<Movie> {
        if(data.results.isNullOrEmpty()){
            throw Exception("Empty results")
        }
        return data.results.map { movieDto ->
            with(movieDto){
                Movie(
                    adult = adult.orFalse(),
                    backdropPath = backdropPath.orEmpty(),
                    genreIds = genreIds.orEmpty(),
                    id = id,
                    originalLanguage = originalLanguage.orEmpty(),
                    originalTitle = originalTitle.orEmpty(),
                    overview = overview.orEmpty(),
                    popularity = popularity.orZero(),
                    posterPath = posterPath.orEmpty(),
                    releaseDate = releaseDate.orEmpty(),
                    title = title.orEmpty(),
                    video = video.orFalse(),
                    voteAverage = voteAverage.orZero(),
                    voteCount = voteCount.orZero(),
                    isFavourite = false
                )
            }
        }
    }
}