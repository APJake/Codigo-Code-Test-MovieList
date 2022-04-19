package com.apjake.codetestmovielist.data.datasource

import com.apjake.codetestmovielist.domain.models.MovieVO
import io.reactivex.rxjava3.core.Observable

interface MovieNetworkDataSource {
    fun getPopularMovieList(): Observable<List<MovieVO>>
    fun getUpcomingMovieList(): Observable<List<MovieVO>>

}