package com.apjake.codetestmovielist.network.di

import com.apjake.codetestmovielist.data.datasource.MovieNetworkDataSource
import com.apjake.codetestmovielist.network.datasource.MovieNetworkDataSourceImpl
import com.apjake.codetestmovielist.network.service.MovieApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {
    @Module
    @InstallIn(SingletonComponent::class)
    object Provide{
        @Provides
        @Singleton
        fun provideMovieService(retrofit: Retrofit): MovieApi =
            retrofit.create(MovieApi::class.java)

        @Provides
        @Singleton
        fun provideRetrofit(@Named("api_key") apiKey: String): Retrofit{
            val client = OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val url = chain
                        .request()
                        .url
                        .newBuilder()
                        .addQueryParameter("api_key", apiKey)
                        .build()
                    chain.proceed(chain.request().newBuilder().url(url).build())
                })
                .build()
            return Retrofit.Builder()
                .baseUrl(MovieApi.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    @Binds
    @Singleton
    abstract fun bindMovieNetworkDataSource(movieNetworkDataSourceImpl: MovieNetworkDataSourceImpl)
            : MovieNetworkDataSource

}