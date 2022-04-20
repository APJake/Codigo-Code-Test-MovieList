package com.apjake.codetestmovielist.local.di

import android.content.Context
import androidx.room.Room
import com.apjake.codetestmovielist.data.datasource.MovieLocalDataSource
import com.apjake.codetestmovielist.local.database.MoviesDatabase
import com.apjake.codetestmovielist.local.datasource.MovieLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule{
    @Module
    @InstallIn(SingletonComponent::class)
    object Provide{
        @Provides
        @Singleton
        fun provideAppDatabase(@ApplicationContext context: Context): MoviesDatabase {
            return Room.databaseBuilder(
                context,
                MoviesDatabase::class.java,
                "movies.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
    @Binds
    @Singleton
    abstract fun bindMovieLocalDataSource(movieLocalDataSourceImpl: MovieLocalDataSourceImpl)
            : MovieLocalDataSource

}