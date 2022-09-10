package com.apjake.codetestmovielist.features.movies.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.apjake.codetestmovielist.common.base.BaseFragment
import com.apjake.codetestmovielist.common.util.show
import com.apjake.codetestmovielist.databinding.FragmentMovieDetailBinding
import com.apjake.codetestmovielist.item.DashboardViewItem.MovieViewItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment: BaseFragment<FragmentMovieDetailBinding ,DetailMovieViewModel>(){

    private val args by navArgs<MovieDetailFragmentArgs>()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMovieDetailBinding
        get() = { inflater, container, isAttach ->
            FragmentMovieDetailBinding.inflate(inflater, container, isAttach)
        }

    override val mainViewModel: DetailMovieViewModel by viewModels()

    override fun setUp() {
        val movie = args.currentMovie

        setUpDetail(movie)
        handleListeners(movie.id)
    }

    override fun observeState() {
    }

    override fun observeEvent() {
    }

    private fun handleListeners(id: Int) {
        binding.tbFavMovie.setOnCheckedChangeListener { _, isChecked ->
            mainViewModel.toggleFavouriteMovie(id, isChecked)
        }
    }

    private fun setUpDetail(movie: MovieViewItem) {
        binding.ivPoster.show(movie.backdropPath)
        binding.tvMovieName.text  = movie.title
        binding.tvMovieOverview.text = movie.overview
        binding.tvRating.text = movie.rating
        binding.tbFavMovie.isChecked = movie.isFavourite
    }

}