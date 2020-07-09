package com.app.test.ui.main.holder

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.app.test.R
import com.app.test.databinding.ItemDataBinding
import com.app.test.model.Row

class DataViewHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(row: Row) {
        binding.dataTitle.text = row.title
        binding.dataDesc.text = row.description
        /*binding.imageView.load(row.imageHref) {
            placeholder(R.drawable.ic_launcher_background)
            error(R.drawable.ic_broken_image) }*/
    }
}