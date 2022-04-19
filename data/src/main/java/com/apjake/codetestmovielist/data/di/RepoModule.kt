package com.apjake.codetestmovielist.data.di

import com.apjake.codetestmovielist.data.repository.MovieRepositoryImpl
import com.apjake.codetestmovielist.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {
    @Binds
    @Singleton
    fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}