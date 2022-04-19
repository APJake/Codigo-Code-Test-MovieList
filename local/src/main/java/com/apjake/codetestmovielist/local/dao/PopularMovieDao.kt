package com.apjake.codetestmovielist.local.dao

import androidx.room.*
import com.apjake.codetestmovielist.local.entity.PopularMovieEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface PopularMovieDao {

    @Query("SELECT * FROM PopularMovie")
    fun getMovies(): Observable<List<PopularMovieEntity>>

    @Query("SELECT * FROM PopularMovie WHERE id == :id")
    fun getMovie(id: Int): Observable<PopularMovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(movieList: List<PopularMovieEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(movie: PopularMovieEntity): Completable

    @Query("DELETE FROM PopularMovie")
    fun deleteAll(): Completable
}