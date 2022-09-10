package com.apjake.codetestmovielist.domain.usecase

import com.apjake.codetestmovielist.domain.repository.MovieRepository
import javax.inject.Inject

class FetchUpcomingMoviesUseCase@Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke() = movieRepository.fetchUpcomingMovieList()
}