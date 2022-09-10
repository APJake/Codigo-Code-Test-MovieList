package com.apjake.codetestmovielist.features.movies.list.adapter

import android.content.Context
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.apjake.codetestmovielist.databinding.LayoutPopularMovieListBinding
import com.apjake.codetestmovielist.databinding.LayoutTitleTextBinding
import com.apjake.codetestmovielist.databinding.SingleUpcomingMovieItemBinding
import com.apjake.codetestmovielist.features.movies.list.adapter.holder.DashboardViewHolder
import com.apjake.codetestmovielist.features.movies.list.adapter.holder.DashboardViewHolder.MovieItemViewHolder
import com.apjake.codetestmovielist.features.movies.list.adapter.holder.DashboardViewHolder.PopularMoviesViewHolder
import com.apjake.codetestmovielist.features.movies.list.adapter.holder.DashboardViewHolder.TitleViewHolder
import com.apjake.codetestmovielist.item.DashboardViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.MovieViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.PopularListViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.TitleViewItem
import com.apjake.codetestmovielist.util.DashboardItemDiffCallback

class DashboardAdapter(
    context: Context,
    private val onFavouriteChanged: ((MovieViewItem, Boolean) -> Unit),
    private val onMovieClick: ((MovieViewItem) -> Unit),
) : ListAdapter<DashboardViewItem, DashboardViewHolder>(DashboardItemDiffCallback) {

    private val scrollStates = mutableMapOf<Int, Parcelable?>()

    companion object {
        private const val TYPE_TITLE = 1
        private const val TYPE_POPULAR = 2
        private const val TYPE_MOVIE = 3
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_TITLE
            1 -> TYPE_POPULAR
            2 -> TYPE_TITLE
            else -> TYPE_MOVIE
        }
    }

    override fun onViewRecycled(holder: DashboardViewHolder) {
        super.onViewRecycled(holder)

        if (holder is PopularMoviesViewHolder) {
            val key = holder.layoutPosition
            scrollStates[key] = holder.binding.rcyPopularMovies.layoutManager?.onSaveInstanceState()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        return when (viewType) {
            TYPE_TITLE -> {
                TitleViewHolder(
                    binding = LayoutTitleTextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            TYPE_POPULAR -> {
                PopularMoviesViewHolder(
                    binding = LayoutPopularMovieListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onMovieClick,
                    onFavouriteChanged
                )
            }
            else -> {
                MovieItemViewHolder(
                    binding = SingleUpcomingMovieItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onMovieClick,
                    onFavouriteChanged
                )
            }
        }
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        when (holder) {
            is TitleViewHolder -> holder.bind(getItem(position) as TitleViewItem)
            is MovieItemViewHolder -> holder.bind(getItem(position) as MovieViewItem)
            is PopularMoviesViewHolder -> {
                val key = holder.layoutPosition
                val state = scrollStates[key]
                holder.bind(getItem(position) as PopularListViewItem)
                if(state!=null){
                    holder.binding.rcyPopularMovies.layoutManager?.onRestoreInstanceState(state)
                }
            }
        }
    }
}