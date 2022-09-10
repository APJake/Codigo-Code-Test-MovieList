package com.apjake.codetestmovielist.local.dao

import androidx.room.*
import com.apjake.codetestmovielist.local.entity.UpcomingMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UpcomingMovieDao {
    @Query("SELECT * FROM UpcomingMovie")
    fun getMovies(): Flow<List<UpcomingMovieEntity>>

    @Query("SELECT * FROM UpcomingMovie WHERE id == :id")
    suspend fun getMovie(id: Int): UpcomingMovieEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAll(movieList: List<UpcomingMovieEntity>)

    @Query("DELETE FROM UpcomingMovie")
    suspend fun deleteAll()

    @Query("UPDATE UpcomingMovie SET is_favourite=:isFavourite WHERE id=:id")
    suspend fun updateFavourite(id: Int, isFavourite: Boolean)
}