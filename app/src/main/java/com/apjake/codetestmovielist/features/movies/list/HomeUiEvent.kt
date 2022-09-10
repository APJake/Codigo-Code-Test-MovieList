package com.apjake.codetestmovielist.features.movies.list

sealed class HomeUiEvent {
    class ShowErrorToast(val message: String): HomeUiEvent()
    class ShowErrorSnackBar(val message: String): HomeUiEvent()
}