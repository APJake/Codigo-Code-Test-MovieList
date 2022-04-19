package com.apjake.codetestmovielist.view.holder

import com.apjake.codetestmovielist.R
import com.apjake.codetestmovielist.common.base.BaseViewHolder
import com.apjake.codetestmovielist.common.util.show
import com.apjake.codetestmovielist.databinding.SinglePopularMovieItemBinding
import com.apjake.codetestmovielist.mvvm.item.MovieItem

class MovieListViewHolder(
    private val binding: SinglePopularMovieItemBinding
): BaseViewHolder<MovieItem>(binding.root) {
    override fun bind(item: MovieItem) {
        super.bind(item)
        binding.ivPoster.show(item.posterPath, R.drawable.ic_error_outline)
        binding.tvMovieName.text = item.title
        binding.tvRating.text = item.rating
    }
}