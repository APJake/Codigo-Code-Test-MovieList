package com.apjake.codetestmovielist.network.service

import com.apjake.codetestmovielist.network.response.MovieListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("/movie/popular")
    fun getPopularMovies(): Observable<MovieListResponse>
    @GET("/movie/upcoming")
    fun getUpcomingMovies(): Observable<MovieListResponse>
}