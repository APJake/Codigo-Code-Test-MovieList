package com.apjake.codetestmovielist.local.dao

import androidx.room.*
import com.apjake.codetestmovielist.local.entity.PopularMovieEntity
import com.apjake.codetestmovielist.local.entity.UpcomingMovieEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface UpcomingMovieDao {

    @Query("SELECT * FROM UpcomingMovie")
    fun getMovies(): Observable<List<UpcomingMovieEntity>>

    @Query("SELECT * FROM UpcomingMovie WHERE id == :id")
    fun getMovie(id: Int): Observable<UpcomingMovieEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAll(movieList: List<UpcomingMovieEntity>)

    @Query("DELETE FROM UpcomingMovie")
    fun deleteAll()

    @Query("UPDATE UpcomingMovie SET isFavourite=:isFavourite WHERE id=:id")
    fun updateFavourite(id: Int, isFavourite: Boolean)
}