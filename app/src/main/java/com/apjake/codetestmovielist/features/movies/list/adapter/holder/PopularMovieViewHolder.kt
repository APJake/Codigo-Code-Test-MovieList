package com.apjake.codetestmovielist.features.movies.list.adapter.holder

import com.apjake.codetestmovielist.common.base.BaseViewHolder
import com.apjake.codetestmovielist.common.util.show
import com.apjake.codetestmovielist.databinding.SinglePopularMovieItemBinding
import com.apjake.codetestmovielist.item.DashboardViewItem.MovieViewItem

class PopularMovieViewHolder(
    val binding: SinglePopularMovieItemBinding
): BaseViewHolder<MovieViewItem>(binding.root) {
    override fun bind(item: MovieViewItem) {
        super.bind(item)
        binding.ivPoster.show(item.posterPath)
        binding.tvMovieName.text = item.title
        binding.tvRating.text = item.rating
        binding.tbFavMovie.isChecked = item.isFavourite
    }
}