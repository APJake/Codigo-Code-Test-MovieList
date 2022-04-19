package com.apjake.codetestmovielist.mvvm.state

import com.apjake.codetestmovielist.mvvm.item.MovieItem

sealed class MovieListState {
    object Empty: MovieListState()
    object Loading: MovieListState()
    class Loaded(val movieList: List<MovieItem>): MovieListState()
    class Error(val message: String): MovieListState()
}