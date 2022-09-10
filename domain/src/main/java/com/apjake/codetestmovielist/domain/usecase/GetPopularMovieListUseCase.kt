package com.apjake.codetestmovielist.domain.usecase

import com.apjake.codetestmovielist.domain.repository.MovieRepository
import javax.inject.Inject

class GetPopularMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke() = movieRepository.getPopularMovieList()
}