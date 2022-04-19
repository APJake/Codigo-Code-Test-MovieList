package com.apjake.codetestmovielist.data.repository

import com.apjake.codetestmovielist.data.datasource.MovieNetworkDataSource
import com.apjake.codetestmovielist.domain.models.MovieVO
import com.apjake.codetestmovielist.domain.repository.MovieRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieNetworkDataSource: MovieNetworkDataSource,

) : MovieRepository{
    override fun getUpcomingMovieList(): Observable<List<MovieVO>> {
        return movieNetworkDataSource.getUpcomingMovieList()
    }

    override fun getPopularMovieList(): Observable<List<MovieVO>> {
        return movieNetworkDataSource.getPopularMovieList()
    }
}