package com.apjake.codetestmovielist.view.holder

import com.apjake.codetestmovielist.common.base.BaseViewHolder
import com.apjake.codetestmovielist.common.util.show
import com.apjake.codetestmovielist.databinding.SinglePopularMovieItemBinding
import com.apjake.codetestmovielist.databinding.SingleUpcomingMovieItemBinding
import com.apjake.codetestmovielist.mvvm.item.MovieItem

class UpcomingMovieViewHolder(
    private val binding: SingleUpcomingMovieItemBinding
): BaseViewHolder<MovieItem>(binding.root) {
    override fun bind(item: MovieItem) {
        super.bind(item)
        binding.ivPoster.show(item.posterPath)
        binding.tvMovieName.text = item.title
        binding.tvMovieOverview.text = item.overview
        binding.tvRating.text = item.rating
        binding.tbFavMovie.isChecked = item.isFavourite
    }
}