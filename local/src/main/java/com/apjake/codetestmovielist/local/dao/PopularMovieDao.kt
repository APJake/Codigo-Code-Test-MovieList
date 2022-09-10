package com.apjake.codetestmovielist.local.dao

import androidx.room.*
import com.apjake.codetestmovielist.local.entity.PopularMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PopularMovieDao {
    @Query("SELECT * FROM PopularMovie")
    fun getMovies(): Flow<List<PopularMovieEntity>>

    @Query("SELECT * FROM PopularMovie WHERE id == :id")
    suspend fun getMovie(id: Int): PopularMovieEntity?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAll(movieList: List<PopularMovieEntity>)

    @Query("DELETE FROM PopularMovie")
    suspend fun deleteAll()

    @Query("UPDATE PopularMovie SET is_favourite=:isFavourite WHERE id=:id")
    suspend fun updateFavourite(id: Int, isFavourite: Boolean)
}