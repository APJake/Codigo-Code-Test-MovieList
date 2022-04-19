package com.apjake.codetestmovielist.domain.usecase

import com.apjake.codetestmovielist.domain.models.MovieVO
import com.apjake.codetestmovielist.domain.repository.MovieRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetUpcomingMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Observable<List<MovieVO>> {
        return getUpcomingMoviesFromNetwork()
    }

//    private fun getPopularMoviesFromLocal(): Observable<List<MovieVO>>{
//        return
//    }

    private fun getUpcomingMoviesFromNetwork(): Observable<List<MovieVO>> {
        return movieRepository.getUpcomingMovieList()
    }

}