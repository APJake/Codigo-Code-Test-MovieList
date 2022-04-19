package com.apjake.codetestmovielist.adapter

import android.content.Context
import android.view.ViewGroup
import com.apjake.codetestmovielist.adapter.diffutil.MovieDiffUtil
import com.apjake.codetestmovielist.common.base.BaseListAdapter
import com.apjake.codetestmovielist.databinding.SinglePopularMovieItemBinding
import com.apjake.codetestmovielist.mvvm.item.MovieItem
import com.apjake.codetestmovielist.view.holder.MovieListViewHolder

class PopularMovieListAdapter(context: Context)
    : BaseListAdapter<MovieItem, MovieListViewHolder>(context = context, diffUtil = MovieDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val binding = SinglePopularMovieItemBinding.inflate(inflater, parent, false)
        return MovieListViewHolder(binding)
    }
}