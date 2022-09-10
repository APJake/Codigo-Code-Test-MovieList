package com.apjake.codetestmovielist.data.repository

import com.apjake.codetestmovielist.data.datasource.MovieLocalDataSource
import com.apjake.codetestmovielist.data.datasource.MovieNetworkDataSource
import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.domain.repository.MovieRepository
import com.apjake.codetestmovielist.domain.util.Resource
import com.apjake.codetestmovielist.domain.util.Resource.Error
import com.apjake.codetestmovielist.domain.util.Resource.Loading
import com.apjake.codetestmovielist.domain.util.Resource.Success
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieNetworkDataSource: MovieNetworkDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
) : MovieRepository {
    override fun getUpcomingMovieList(): Flow<List<Movie>> {
        return movieLocalDataSource.getUpcomingMovieList()
    }

    override fun getPopularMovieList(): Flow<List<Movie>> {
        return movieLocalDataSource.getPopularMovieList()
    }

    override fun updateFavouriteMovie(id: Int, isFavourite: Boolean): Flow<Resource<Movie>> = flow {
        try {
            movieLocalDataSource.updateFavourite(id, isFavourite)
            val movie = movieLocalDataSource.getMovieById(id)
            emit(Resource.Success(movie))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }

    override fun fetchUpcomingMovieList(): Flow<Resource<Void>> {
        return movieNetworkDataSource.fetchUpcomingMovieList()
            .onEach { result ->
                if (result is Success) {
                    result.data?.let {
                        movieLocalDataSource.setUpcomingMovieList(it)
                    }
                }
            }
            .map<Resource<List<Movie>>, Resource<Void>> { result ->
                when (result) {
                    is Success -> {
                        Success(null)
                    }
                    is Loading -> {
                        Loading()
                    }
                    is Error -> {
                        Error(result.message)
                    }
                }
            }
    }

    override fun fetchPopularMovieList(): Flow<Resource<Void>> {
        return movieNetworkDataSource.fetchPopularMovieList()
            .onEach { result ->
                if (result is Success) {
                    result.data?.let {
                        movieLocalDataSource.setPopularMovieList(it)
                    }
                }
            }
            .map<Resource<List<Movie>>, Resource<Void>> { result ->
                when (result) {
                    is Success -> {
                        Success(null)
                    }
                    is Loading -> {
                        Loading()
                    }
                    is Error -> {
                        Error(result.message)
                    }
                }
            }
    }

}