package com.apjake.codetestmovielist.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.apjake.codetestmovielist.mvvm.item.MovieItem

object MovieDiffUtil : DiffUtil.ItemCallback<MovieItem>() {
    override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
        return oldItem == newItem
    }
}