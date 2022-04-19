package com.apjake.codetestmovielist.network.datasource

import com.apjake.codetestmovielist.data.datasource.MovieNetworkDataSource
import com.apjake.codetestmovielist.domain.models.MovieVO
import com.apjake.codetestmovielist.network.mapper.MovieResponseMapper
import com.apjake.codetestmovielist.network.service.MovieApi
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MovieNetworkDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val movieResponseMapper: MovieResponseMapper
): MovieNetworkDataSource {
    override fun getPopularMovieList(): Observable<List<MovieVO>> {
        return movieApi.getPopularMovies().map {
            movieResponseMapper.map(it.results)
        }
    }

    override fun getUpcomingMovieList(): Observable<List<MovieVO>> {
        return movieApi.getUpcomingMovies().map {
            movieResponseMapper.map(it.results)
        }
    }
}