package com.apjake.codetestmovielist.adapter

import android.content.Context
import android.view.ViewGroup
import com.apjake.codetestmovielist.adapter.diffutil.MovieDiffUtil
import com.apjake.codetestmovielist.common.base.BaseListAdapter
import com.apjake.codetestmovielist.databinding.SinglePopularMovieItemBinding
import com.apjake.codetestmovielist.mvvm.item.MovieItem
import com.apjake.codetestmovielist.view.holder.PopularMovieViewHolder


class PopularMovieListAdapter(context: Context)
    : BaseListAdapter<MovieItem, PopularMovieViewHolder>(context = context, diffUtil = MovieDiffUtil) {
    var onItemCheck: ((MovieItem, Boolean) -> Unit)? =null
    var onItemClick: ((MovieItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val binding = SinglePopularMovieItemBinding.inflate(inflater, parent, false)
        val viewHolder = PopularMovieViewHolder(binding)
        binding.tbFavMovie.setOnCheckedChangeListener { _, isChecked ->
            onItemCheck?.invoke(getItem(viewHolder.adapterPosition), isChecked)
        }
        binding.llItem.setOnClickListener{
            onItemClick?.invoke(getItem(viewHolder.adapterPosition))
        }
        return viewHolder
    }
}