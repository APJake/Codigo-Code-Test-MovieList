package com.apjake.codetestmovielist.data.datasource

import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {
    fun getPopularMovieList(): Flow<List<Movie>>
    fun getUpcomingMovieList(): Flow<List<Movie>>
    suspend fun clearPopularMovieList()
    suspend fun clearUpcomingMovieList()
    suspend fun setPopularMovieList(movies: List<Movie>)
    suspend fun setUpcomingMovieList(movies: List<Movie>)
    suspend fun updateFavourite(id: Int, isFavourite: Boolean)
    suspend fun getMovieById(id: Int): Movie?
}