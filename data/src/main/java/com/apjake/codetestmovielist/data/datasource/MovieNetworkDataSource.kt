package com.apjake.codetestmovielist.data.datasource

import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieNetworkDataSource {
    fun fetchPopularMovieList(): Flow<Resource<List<Movie>>>
    fun fetchUpcomingMovieList(): Flow<Resource<List<Movie>>>
}