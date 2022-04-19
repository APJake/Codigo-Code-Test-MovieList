package com.apjake.codetestmovielist.network.di

import android.content.Context
import com.apjake.codetestmovielist.data.datasource.MovieNetworkDataSource
import com.apjake.codetestmovielist.network.datasource.MovieNetworkDataSourceImpl
import com.apjake.codetestmovielist.network.service.MovieApi
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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
        fun provideRetrofit(@ApplicationContext context: Context): Retrofit{

            val client = OkHttpClient.Builder()
                .addInterceptor(ChuckerInterceptor(context))
                .addInterceptor(Interceptor { chain ->
                    val url = chain
                        .request()
                        .url
                        .newBuilder()
                        .addQueryParameter("api_key", "c1344f49636138e12c007ee2cf3e7393")
                        .build()
                    chain.proceed(chain.request().newBuilder().url(url).build())
                })
                .build()
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(client)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    @Binds
    @Singleton
    abstract fun bindMovieNetworkDataSource(movieNetworkDataSourceImpl: MovieNetworkDataSourceImpl)
            : MovieNetworkDataSource

}