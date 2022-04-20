package com.apjake.codetestmovielist.domain.repository

import com.apjake.codetestmovielist.domain.models.MovieVO
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

interface MovieRepository {
    fun getUpcomingMovieList(): Observable<List<MovieVO>>
    fun getPopularMovieList(): Observable<List<MovieVO>>
    fun updateFavouriteMovie(id: Int, isFavourite: Boolean)
}