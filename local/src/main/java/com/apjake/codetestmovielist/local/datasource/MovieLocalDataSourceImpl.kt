package com.apjake.codetestmovielist.local.datasource

import com.apjake.codetestmovielist.data.datasource.MovieLocalDataSource
import com.apjake.codetestmovielist.domain.models.Movie
import com.apjake.codetestmovielist.local.database.MoviesDatabase
import com.apjake.codetestmovielist.local.mapper.PopularMovieEntityMapper
import com.apjake.codetestmovielist.local.mapper.UpcomingMovieEntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val database: MoviesDatabase,
    private val popularMovieEntityMapper: PopularMovieEntityMapper,
    private val upcomingMovieEntityMapper: UpcomingMovieEntityMapper,
) : MovieLocalDataSource {

    override fun getPopularMovieList(): Flow<List<Movie>> {
        return database.popularMovieDao().getMovies().map { movieList ->
            movieList.map {
                popularMovieEntityMapper.map(it)
            }
        }
    }

    override fun getUpcomingMovieList(): Flow<List<Movie>> {
        return database.upcomingMovieDao().getMovies().map { movieList ->
            movieList.map {
                upcomingMovieEntityMapper.map(it)
            }
        }
    }

    override suspend fun clearPopularMovieList() {
        database.popularMovieDao().deleteAll()
    }

    override suspend fun clearUpcomingMovieList() {
        database.upcomingMovieDao().deleteAll()
    }

    override suspend fun setPopularMovieList(movies: List<Movie>) {
        database.popularMovieDao().addAll(movieList = movies.map { popularMovieEntityMapper.mapReverse(it) })
    }

    override suspend fun setUpcomingMovieList(movies: List<Movie>) {
        database.upcomingMovieDao()
            .addAll(movieList = movies.map { upcomingMovieEntityMapper.mapReverse(it) })
    }

    override suspend fun updateFavourite(id: Int, isFavourite: Boolean) {
        database.upcomingMovieDao().updateFavourite(id, isFavourite)
        database.popularMovieDao().updateFavourite(id, isFavourite)
    }

    override suspend fun getMovieById(id: Int): Movie? {
        val popularMovie = database.popularMovieDao().getMovie(id)
        popularMovie?.let {
            return popularMovieEntityMapper.map(it)
        }
        val upcomingMovie = database.upcomingMovieDao().getMovie(id)
        upcomingMovie?.let {
            return upcomingMovieEntityMapper.map(it)
        }
        return null
    }

}