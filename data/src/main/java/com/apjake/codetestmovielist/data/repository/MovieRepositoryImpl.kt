package com.apjake.codetestmovielist.data.repository

import com.apjake.codetestmovielist.data.datasource.MovieLocalDataSource
import com.apjake.codetestmovielist.data.datasource.MovieNetworkDataSource
import com.apjake.codetestmovielist.domain.models.MovieVO
import com.apjake.codetestmovielist.domain.repository.MovieRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieNetworkDataSource: MovieNetworkDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
) : MovieRepository{
    override fun getUpcomingMovieList(): Observable<List<MovieVO>> {
//        movieNetworkDataSource.getUpcomingMovieList().map {
//            movieLocalDataSource.setUpcomingMovieList(it)
//        }
        return movieLocalDataSource.getUpcomingMovieList()
    }

    override fun getPopularMovieList(): Observable<List<MovieVO>> {
//        movieNetworkDataSource.getPopularMovieList().map{
//            movieLocalDataSource.setPopularMovieList(it)
//        }
        return movieNetworkDataSource.getPopularMovieList()
    }
}