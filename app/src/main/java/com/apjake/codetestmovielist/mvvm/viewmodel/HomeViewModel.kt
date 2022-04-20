package com.apjake.codetestmovielist.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apjake.codetestmovielist.common.base.BaseViewModel
import com.apjake.codetestmovielist.domain.usecase.AddToFavMovieUseCase
import com.apjake.codetestmovielist.domain.usecase.GetPopularMovieListUseCase
import com.apjake.codetestmovielist.domain.usecase.GetUpcomingMovieListUseCase
import com.apjake.codetestmovielist.mvvm.mapper.MovieItemMapper
import com.apjake.codetestmovielist.mvvm.state.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMovieListUseCase: GetPopularMovieListUseCase,
    private val getUpcomingMovieListUseCase: GetUpcomingMovieListUseCase,
    private val addToFavMovieUseCase: AddToFavMovieUseCase,
    private val movieItemMapper: MovieItemMapper
): BaseViewModel() {
    private val _popularMovieListState = MutableLiveData<MovieListState>().apply {
        value = MovieListState.Loading
    }
    val popularMovieListState: LiveData<MovieListState> = _popularMovieListState

    private val _upcomingMovieListState = MutableLiveData<MovieListState>().apply {
        value = MovieListState.Loading
    }
    val upcomingMovieListState: LiveData<MovieListState> = _upcomingMovieListState

    fun getPopularMovieList(){
        getPopularMovieListUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _popularMovieListState.value = MovieListState.Loaded(movieItemMapper.map(it))
                },
                {
                    _popularMovieListState.value = MovieListState.Error(it.message.orEmpty())
                }
            )
            .addTo(dispose)
    }
    fun getUpcomingMovieList(){
        getUpcomingMovieListUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _upcomingMovieListState.value = MovieListState.Loaded(movieItemMapper.map(it))
                },
                {
                    _upcomingMovieListState.value = MovieListState.Error(it.message.orEmpty())
                }
            )
            .addTo(dispose)
    }

    fun toggleFavouriteMovie(id: Int, isFavourite: Boolean){
        addToFavMovieUseCase(id, isFavourite)
    }
}