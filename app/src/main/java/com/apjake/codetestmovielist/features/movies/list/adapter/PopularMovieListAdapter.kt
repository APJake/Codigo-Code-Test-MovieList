package com.apjake.codetestmovielist.features.movies.list.adapter

import android.content.Context
import android.view.ViewGroup
import com.apjake.codetestmovielist.common.base.BaseListAdapter
import com.apjake.codetestmovielist.databinding.SinglePopularMovieItemBinding
import com.apjake.codetestmovielist.features.movies.list.adapter.holder.PopularMovieViewHolder
import com.apjake.codetestmovielist.item.DashboardViewItem.MovieViewItem
import com.apjake.codetestmovielist.util.MovieViewItemDiffCallback

class PopularMovieListAdapter(
    context: Context,
    private val onMovieClick: ((MovieViewItem) -> Unit),
    private val onFavouriteCheckChanged: ((MovieViewItem, Boolean) -> Unit)
) : BaseListAdapter<MovieViewItem, PopularMovieViewHolder>(
    context = context,
    diffUtil = MovieViewItemDiffCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val binding = SinglePopularMovieItemBinding.inflate(inflater, parent, false)
        val viewHolder = PopularMovieViewHolder(binding)
        binding.tbFavMovie.setOnCheckedChangeListener { _, isChecked ->
            onFavouriteCheckChanged.invoke(getItem(viewHolder.adapterPosition), isChecked)
        }
        binding.llItem.setOnClickListener{
            onMovieClick.invoke(getItem(viewHolder.adapterPosition))
        }
        return viewHolder
    }
}