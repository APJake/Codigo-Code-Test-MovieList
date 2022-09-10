package com.apjake.codetestmovielist.features.movies.list.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.apjake.codetestmovielist.common.util.show
import com.apjake.codetestmovielist.databinding.LayoutPopularMovieListBinding
import com.apjake.codetestmovielist.databinding.LayoutTitleTextBinding
import com.apjake.codetestmovielist.databinding.SingleUpcomingMovieItemBinding
import com.apjake.codetestmovielist.features.movies.list.adapter.PopularMovieListAdapter
import com.apjake.codetestmovielist.item.DashboardViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.MovieViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.PopularListViewItem

sealed class DashboardViewHolder(
    binding: ViewBinding
): RecyclerView.ViewHolder(binding.root){

    class TitleViewHolder(
        private val binding: LayoutTitleTextBinding
    ): DashboardViewHolder(binding){
        fun bind(item: DashboardViewItem.TitleViewItem){
            binding.tvTitle.text = item.title
        }
    }

    class MovieItemViewHolder(
        private val binding: SingleUpcomingMovieItemBinding,
        private val onMovieClick: (MovieViewItem) -> Unit,
        private val onFavouriteCheckChanged: (MovieViewItem, Boolean) -> Unit
    ): DashboardViewHolder(binding){
        fun bind(movie: MovieViewItem){
            binding.root.setOnClickListener {
                onMovieClick(movie)
            }
            binding.ivPoster.show(movie.posterPath)
            binding.tvMovieOverview.text = movie.overview
            binding.tvMovieName.text = movie.title
            binding.tvRating.text = movie.rating
            binding.tbFavMovie.isChecked = movie.isFavourite
            binding.tbFavMovie.setOnCheckedChangeListener { _, isChecked ->
                onFavouriteCheckChanged.invoke(movie, isChecked)
            }
        }
    }

    class PopularMoviesViewHolder(
        val binding: LayoutPopularMovieListBinding,
        private val onMovieClick: (MovieViewItem) -> Unit,
        private val onFavouriteCheckChanged: (MovieViewItem, Boolean) -> Unit,
    ): DashboardViewHolder(binding){
        private val adapter = PopularMovieListAdapter(
            binding.root.context,
            onMovieClick,
            onFavouriteCheckChanged
        )
        fun bind(item: PopularListViewItem){
            binding.rcyPopularMovies.adapter = adapter
            adapter.submitList(item.movies)
        }
    }

}