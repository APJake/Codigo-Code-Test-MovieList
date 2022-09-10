package com.apjake.codetestmovielist.domain.usecase

import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.domain.repository.MovieRepository
import com.apjake.codetestmovielist.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddToFavMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(id: Int, isFavourite: Boolean): Flow<Resource<Movie>> {
        return movieRepository.updateFavouriteMovie(id, isFavourite)
    }

}