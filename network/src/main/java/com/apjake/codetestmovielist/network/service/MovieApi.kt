package com.apjake.codetestmovielist.network.service

import com.apjake.codetestmovielist.network.response.MovieListResponse
import retrofit2.http.GET

interface MovieApi {
    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }
    @GET("movie/popular")
    suspend fun getPopularMovies(): MovieListResponse
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): MovieListResponse
}