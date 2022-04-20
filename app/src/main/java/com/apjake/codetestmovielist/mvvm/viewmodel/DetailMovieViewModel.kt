package com.apjake.codetestmovielist.mvvm.viewmodel

import com.apjake.codetestmovielist.common.base.BaseViewModel
import com.apjake.codetestmovielist.domain.usecase.AddToFavMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val addToFavMovieUseCase: AddToFavMovieUseCase
): BaseViewModel() {
    fun toggleFavouriteMovie(id: Int, isFavourite: Boolean){
        addToFavMovieUseCase(id, isFavourite)
    }
}