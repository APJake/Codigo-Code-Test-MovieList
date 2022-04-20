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
    var onItemCheck: ((MovieItem, Boolean) -> Unit)? =null
    var onItemClick: ((MovieItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMovieViewHolder {
        val binding = SingleUpcomingMovieItemBinding.inflate(inflater, parent, false)
        val viewHolder = UpcomingMovieViewHolder(binding)
        binding.tbFavMovie.setOnCheckedChangeListener { _, isChecked ->
            onItemCheck?.invoke(getItem(viewHolder.adapterPosition), isChecked)
        }
        binding.llItem.setOnClickListener{
            onItemClick?.invoke(getItem(viewHolder.adapterPosition))
        }
        return viewHolder
    }
}