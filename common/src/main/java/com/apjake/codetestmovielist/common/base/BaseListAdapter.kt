package com.apjake.codetestmovielist.common.base

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter<itemType, viewType : BaseViewHolder<itemType>>(
    context: Context,
    diffUtil: DiffUtil.ItemCallback<itemType>
) : ListAdapter<itemType, viewType>(diffUtil) {

    val inflater: LayoutInflater by lazy { LayoutInflater.from(context) }

    override fun onBindViewHolder(holder: viewType, position: Int) {
        holder.bind(getItem(position))
    }

    fun setNewDataList(dataList: List<itemType>) {
        submitList(dataList)
    }
}