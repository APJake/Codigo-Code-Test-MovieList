package com.apjake.codetestmovielist.domain.usecase

import com.apjake.codetestmovielist.domain.models.MovieVO
import com.apjake.codetestmovielist.domain.repository.MovieRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class AddToFavMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(id: Int, isFavourite: Boolean) {
        movieRepository.updateFavouriteMovie(id, isFavourite)
    }

}