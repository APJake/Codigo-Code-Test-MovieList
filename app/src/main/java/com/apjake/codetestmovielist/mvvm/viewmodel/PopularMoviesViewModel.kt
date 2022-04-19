package com.apjake.codetestmovielist.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.apjake.codetestmovielist.common.base.BaseViewModel
import com.apjake.codetestmovielist.domain.usecase.GetPopularMovieListUseCase
import com.apjake.codetestmovielist.mvvm.mapper.MovieItemMapper
import com.apjake.codetestmovielist.mvvm.state.MovieListState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PopularMoviesViewModel @Inject constructor(
    private val getPopularMovieListUseCase: GetPopularMovieListUseCase,
    private val movieItemMapper: MovieItemMapper
): BaseViewModel() {

    private val _movieListState = MutableLiveData<MovieListState>().apply {
        value = MovieListState.Loading
    }
    val movieListState: LiveData<MovieListState> = _movieListState

    fun getMovieList(){
        getPopularMovieListUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _movieListState.value = MovieListState.Loaded(movieItemMapper.map(it))
                },
                {
                    _movieListState.value = MovieListState.Error(it.message.orEmpty())
                }
            )
            .addTo(dispose)
    }

}