package com.apjake.codetestmovielist.util

import androidx.recyclerview.widget.DiffUtil
import com.apjake.codetestmovielist.item.DashboardViewItem.MovieViewItem

object MovieViewItemDiffCallback : DiffUtil.ItemCallback<MovieViewItem>() {
    override fun areItemsTheSame(oldItem: MovieViewItem, newItem: MovieViewItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieViewItem, newItem: MovieViewItem): Boolean {
        return oldItem == newItem
    }
}