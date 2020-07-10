package com.app.test.ui.main.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.app.test.R
import com.app.test.databinding.ItemDataBinding
import com.app.test.model.Row

class DataViewHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(row: Row) {
        if (row.title.isNullOrBlank() && row.title.isNullOrBlank() && row.title.isNullOrBlank())
            binding.contentData.visibility = View.GONE

        if (!row.title.isNullOrEmpty()) binding.dataTitle.text = row.title
        else binding.dataTitle.visibility= View.GONE

        if (!row.description.isNullOrEmpty()) binding.dataDesc.text = row.description
        else binding.dataDesc.visibility = View.GONE

        if (!row.imageHref.isNullOrEmpty())
        binding.imageView.load(row.imageHref) {
            placeholder(R.drawable.ic_launcher_background)
            error(R.drawable.ic_broken_image) }
        else binding.imageView.visibility = View.GONE
    }
}