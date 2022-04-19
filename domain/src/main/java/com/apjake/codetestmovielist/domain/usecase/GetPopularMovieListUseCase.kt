package com.apjake.codetestmovielist.domain.usecase

import com.apjake.codetestmovielist.domain.models.MovieVO
import com.apjake.codetestmovielist.domain.repository.MovieRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetPopularMovieListUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Observable<List<MovieVO>> {
        return getPopularMoviesFromNetwork()
    }

//    private fun getPopularMoviesFromLocal(): Observable<List<MovieVO>>{
//        return
//    }

    private fun getPopularMoviesFromNetwork(): Observable<List<MovieVO>>{
        return movieRepository.getPopularMovieList()
    }

}