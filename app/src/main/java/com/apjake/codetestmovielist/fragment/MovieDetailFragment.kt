package com.apjake.codetestmovielist.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.apjake.codetestmovielist.adapter.PopularMovieListAdapter
import com.apjake.codetestmovielist.adapter.UpcomingMovieListAdapter
import com.apjake.codetestmovielist.common.base.BaseFragment
import com.apjake.codetestmovielist.common.util.show
import com.apjake.codetestmovielist.databinding.FragmentHomeBinding
import com.apjake.codetestmovielist.databinding.FragmentMovieDetailBinding
import com.apjake.codetestmovielist.mvvm.item.MovieItem
import com.apjake.codetestmovielist.mvvm.viewmodel.DetailMovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment: BaseFragment<DetailMovieViewModel>(){
    private val viewModel: DetailMovieViewModel by viewModels()
    private lateinit var binding: FragmentMovieDetailBinding
    private val args by navArgs<MovieDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)

        val movie = args.currentMovie
        setUpDetail(movie)
        handleListeners(movie.id)

        return binding.root
    }

    private fun handleListeners(id: Int) {
        binding.tbFavMovie.setOnCheckedChangeListener { _, isChecked ->
            viewModel.toggleFavouriteMovie(id, isChecked)
        }
    }

    private fun setUpDetail(movie: MovieItem) {
        binding.ivPoster.show(movie.posterPath)
        binding.tvMovieName.text  = movie.title
        binding.tvMovieOverview.text = movie.overview
        binding.tvRating.text = movie.rating
        binding.tbFavMovie.isChecked = movie.isFavourite
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun injectViewModel(): DetailMovieViewModel = viewModel
}