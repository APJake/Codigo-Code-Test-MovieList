package com.apjake.codetestmovielist.local.database

import androidx.room.*
import com.apjake.codetestmovielist.local.dao.PopularMovieDao
import com.apjake.codetestmovielist.local.dao.UpcomingMovieDao
import com.apjake.codetestmovielist.local.entity.PopularMovieEntity
import com.apjake.codetestmovielist.local.entity.UpcomingMovieEntity
import com.apjake.codetestmovielist.local.entity.converter.Converters

@Database(
    entities = [PopularMovieEntity::class, UpcomingMovieEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun upcomingMovieDao(): UpcomingMovieDao
}