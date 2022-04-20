package com.apjake.codetestmovielist.local.datasource

import android.util.Log
import com.apjake.codetestmovielist.data.datasource.MovieLocalDataSource
import com.apjake.codetestmovielist.domain.models.MovieVO
import com.apjake.codetestmovielist.local.database.MoviesDatabase
import com.apjake.codetestmovielist.local.entity.PopularMovieEntity
import com.apjake.codetestmovielist.local.mapper.PopularMovieEntityMapper
import com.apjake.codetestmovielist.local.mapper.UpcomingMovieEntityMapper
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val database: MoviesDatabase,
    private val popularMovieEntityMapper: PopularMovieEntityMapper,
    private val upcomingMovieEntityMapper: UpcomingMovieEntityMapper
): MovieLocalDataSource {
    override fun getPopularMovieList(): Observable<List<MovieVO>> {
        return database.popularMovieDao().getMovies().map {
            popularMovieEntityMapper.map(it)
        }
    }

    override fun getUpcomingMovieList(): Observable<List<MovieVO>> {
        return database.upcomingMovieDao().getMovies().map {
            upcomingMovieEntityMapper.map(it)
        }
    }

    override fun clearPopularMovieList() {
         database.popularMovieDao().deleteAll()
    }

    override fun clearUpcomingMovieList() {
         database.upcomingMovieDao().deleteAll()
    }

    override fun setPopularMovieList(movies: List<MovieVO>) {
         database.popularMovieDao().addAll(movieList = popularMovieEntityMapper.mapToEntity(movies))
    }

    override fun setUpcomingMovieList(movies: List<MovieVO>) {
         database.upcomingMovieDao().addAll(movieList = upcomingMovieEntityMapper.mapToEntity(movies))
    }

    override fun updateFavourite(id: Int, isFavourite: Boolean) {
        database.upcomingMovieDao().updateFavourite(id, isFavourite)
        database.popularMovieDao().updateFavourite(id, isFavourite)
    }

}