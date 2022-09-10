package com.apjake.codetestmovielist.features.movies.detail

import androidx.lifecycle.viewModelScope
import com.apjake.codetestmovielist.common.base.BaseViewModel
import com.apjake.codetestmovielist.domain.usecase.AddToFavMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailMovieViewModel @Inject constructor(
    private val addToFavMovieUseCase: AddToFavMovieUseCase
): BaseViewModel() {
    private var toggleFavouriteJob: Job? = null

    fun toggleFavouriteMovie(id: Int, isFavourite: Boolean){
        toggleFavouriteJob?.cancel()
        toggleFavouriteJob = viewModelScope.launch {
            addToFavMovieUseCase(id, isFavourite).collect{}
        }
    }
}