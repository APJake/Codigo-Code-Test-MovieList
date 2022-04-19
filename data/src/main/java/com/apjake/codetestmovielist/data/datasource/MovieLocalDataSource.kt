package com.apjake.codetestmovielist.data.datasource

import com.apjake.codetestmovielist.domain.models.MovieVO
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface MovieLocalDataSource {
    fun getPopularMovieList(): Observable<List<MovieVO>>
    fun getUpcomingMovieList(): Observable<List<MovieVO>>
    fun clearPopularMovieList()
    fun clearUpcomingMovieList()
    fun setPopularMovieList(movies: List<MovieVO>)
    fun setUpcomingMovieList(movies: List<MovieVO>)
}