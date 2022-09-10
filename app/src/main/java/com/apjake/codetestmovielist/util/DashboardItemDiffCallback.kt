package com.apjake.codetestmovielist.util

import androidx.recyclerview.widget.DiffUtil
import com.apjake.codetestmovielist.item.DashboardViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.MovieViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.PopularListViewItem
import com.apjake.codetestmovielist.item.DashboardViewItem.TitleViewItem

object DashboardItemDiffCallback : DiffUtil.ItemCallback<DashboardViewItem>() {
    override fun areItemsTheSame(oldItem: DashboardViewItem, newItem: DashboardViewItem): Boolean {
        return when{
            oldItem is TitleViewItem
                    && newItem is TitleViewItem -> oldItem.id == newItem.id
            oldItem is PopularListViewItem
                    && newItem is PopularListViewItem -> oldItem.id == newItem.id
            oldItem is MovieViewItem
                    && newItem is MovieViewItem -> oldItem.id == newItem.id
            else -> false
        }
    }

    override fun areContentsTheSame(oldItem: DashboardViewItem, newItem: DashboardViewItem): Boolean {
        return oldItem == newItem
    }
}