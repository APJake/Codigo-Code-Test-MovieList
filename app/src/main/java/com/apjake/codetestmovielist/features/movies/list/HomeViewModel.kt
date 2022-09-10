package com.apjake.codetestmovielist.features.movies.list

import androidx.lifecycle.viewModelScope
import com.apjake.codetestmovielist.common.base.BaseViewModel
import com.apjake.codetestmovielist.common.util.orUnhandledError
import com.apjake.codetestmovielist.domain.usecase.AddToFavMovieUseCase
import com.apjake.codetestmovielist.domain.usecase.FetchPopularMoviesUseCase
import com.apjake.codetestmovielist.domain.usecase.FetchUpcomingMoviesUseCase
import com.apjake.codetestmovielist.domain.usecase.GetPopularMovieListUseCase
import com.apjake.codetestmovielist.domain.usecase.GetUpcomingMovieListUseCase
import com.apjake.codetestmovielist.domain.util.Resource.Error
import com.apjake.codetestmovielist.domain.util.Resource.Loading
import com.apjake.codetestmovielist.domain.util.Resource.Success
import com.apjake.codetestmovielist.features.movies.list.HomeUiEvent.ShowErrorSnackBar
import com.apjake.codetestmovielist.mapper.DashboardItemMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMovieListUseCase: GetPopularMovieListUseCase,
    private val getUpcomingMovieListUseCase: GetUpcomingMovieListUseCase,
    private val fetchPopularMoviesUseCase: FetchPopularMoviesUseCase,
    private val fetchUpcomingMoviesUseCase: FetchUpcomingMoviesUseCase,
    private val addToFavMovieUseCase: AddToFavMovieUseCase
): BaseViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()
    private val _event = Channel<HomeUiEvent>()
    val event = _event.receiveAsFlow()

    private var toggleFavouriteJob: Job? = null

    init {
        fetchMovieList()
        getPopularMovies()
        getUpcomingMovies()
    }

    private fun getPopularMovies(){
        viewModelScope.launch {
            getPopularMovieListUseCase().collectLatest { movies ->
                _state.value = _state.value.copy(
                    dashboardItems = DashboardItemMapper.mapPopularMovies(
                        items = _state.value.dashboardItems,
                        popularList = movies
                    )
                )
            }
        }
    }

    private fun getUpcomingMovies(){
        viewModelScope.launch {
            getUpcomingMovieListUseCase().collectLatest { movies ->
                _state.value = _state.value.copy(
                    dashboardItems = DashboardItemMapper.mapUpcomingMovies(
                        items = _state.value.dashboardItems,
                        upcomingList = movies
                    )
                )
            }
        }
    }

    fun fetchMovieList(){
        _state.value = _state.value.copy(
            isLoading = true
        )
        viewModelScope.launch {
            merge(fetchPopularMoviesUseCase(), fetchUpcomingMoviesUseCase()).collect{ result ->
                when(result){
                    is Error -> {
                        _state.value = _state.value.copy(
                            isLoading = false
                        )
                        _event.send(ShowErrorSnackBar(result.message.orUnhandledError()))
                    }
                    is Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                    }
                    is Success -> {
                        _state.value = _state.value.copy(
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    fun toggleFavouriteMovie(id: Int, isFavourite: Boolean){
        toggleFavouriteJob?.cancel()
        toggleFavouriteJob = viewModelScope.launch {
            addToFavMovieUseCase(id, isFavourite).collect{ result ->
                when(result){
                    is Error -> _event.send(ShowErrorSnackBar(result.message.orUnhandledError()))
                    is Loading -> {}
                    is Success -> {}
                }
            }
        }
    }
}