package com.apjake.codetestmovielist.adapter

import android.content.Context
import android.view.ViewGroup
import com.apjake.codetestmovielist.adapter.diffutil.MovieDiffUtil
import com.apjake.codetestmovielist.common.base.BaseListAdapter
import com.apjake.codetestmovielist.databinding.SingleUpcomingMovieItemBinding
import com.apjake.codetestmovielist.mvvm.item.MovieItem
import com.apjake.codetestmovielist.view.holder.PopularMovieViewHolder
import com.apjake.codetestmovielist.view.holder.UpcomingMovieViewHolder

class UpcomingMovieListAdapter(context: Context)
    : BaseListAdapter<MovieItem, UpcomingMovieViewHolder>(context = context, diffUtil = MovieDiffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMovieViewHolder {
        val binding = SingleUpcomingMovieItemBinding.inflate(inflater, parent, false)
        return UpcomingMovieViewHolder(binding)
    }
}