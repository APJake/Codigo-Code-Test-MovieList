package com.apjake.codetestmovielist.di

import com.apjake.codetestmovielist.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    @Named("api_key")
    fun provideMovieApiKey() = BuildConfig.API_KEY
}