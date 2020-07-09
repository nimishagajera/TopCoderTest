package com.app.test.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.test.databinding.ItemDataBinding
import com.app.test.model.Row
import com.app.test.ui.main.holder.DataViewHolder

/**
 * Adapter class [RecyclerView.Adapter] for [RecyclerView] which binds [Row] along with [DataViewHolder]
 */
class DataAdapter : ListAdapter<Row, DataViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        ItemDataBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Row>() {

            override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean =
                oldItem.id == newItem.id
        }
    }
}