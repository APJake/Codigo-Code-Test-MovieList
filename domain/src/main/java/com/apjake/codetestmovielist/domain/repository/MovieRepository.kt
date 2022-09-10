package com.apjake.codetestmovielist.domain.repository

import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getUpcomingMovieList(): Flow<List<Movie>>
    fun getPopularMovieList(): Flow<List<Movie>>
    fun updateFavouriteMovie(id: Int, isFavourite: Boolean): Flow<Resource<Movie>>

    fun fetchUpcomingMovieList(): Flow<Resource<Void>>
    fun fetchPopularMovieList(): Flow<Resource<Void>>

}