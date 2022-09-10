package com.apjake.codetestmovielist.domain.usecase

import com.apjake.codetestmovielist.domain.repository.MovieRepository
import javax.inject.Inject

class GetUpcomingMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke() = movieRepository.getUpcomingMovieList()
}