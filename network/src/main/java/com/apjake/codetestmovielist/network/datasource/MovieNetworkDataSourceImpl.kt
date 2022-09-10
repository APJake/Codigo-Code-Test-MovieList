package com.apjake.codetestmovielist.network.datasource

import com.apjake.codetestmovielist.data.datasource.MovieNetworkDataSource
import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.domain.util.Resource
import com.apjake.codetestmovielist.domain.util.Resource.Loading
import com.apjake.codetestmovielist.domain.util.Resource.Success
import com.apjake.codetestmovielist.network.mapper.MovieResponseMapper
import com.apjake.codetestmovielist.network.service.MovieApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MovieNetworkDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val movieResponseMapper: MovieResponseMapper
): MovieNetworkDataSource {
    override fun fetchPopularMovieList(): Flow<Resource<List<Movie>>> = flow {
        emit(Loading())
        try {
            val movieList = movieResponseMapper.map(movieApi.getPopularMovies())
            emit(Success(movieList))
        }catch (e: HttpException){
            emit(Resource.Error(e.message))
        }catch (e: IOException){
            emit(Resource.Error("No internet connection"))
        }catch (e: Exception){
            emit(Resource.Error("Something went wrong"))
        }
    }

    override fun fetchUpcomingMovieList(): Flow<Resource<List<Movie>>> = flow {
        emit(Loading())
        try{
            val movieList = movieResponseMapper.map(movieApi.getUpcomingMovies())
            emit(Success(movieList))
        }catch (e: HttpException){
            emit(Resource.Error(e.message))
        }catch (e: IOException){
            emit(Resource.Error("No internet connection"))
        }catch (e: Exception){
            emit(Resource.Error("Something went wrong"))
        }
    }

}