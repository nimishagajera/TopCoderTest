package com.app.test.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.test.databinding.LayoutRowBinding
import com.app.test.model.DataResponse
import com.app.test.model.Row

class DataRecyclerViewAdapter(val context:Context,
                              var listData: MutableList<DataResponse>) : RecyclerView.Adapter<DataRecyclerViewAdapter.DataHolder>() {

    private lateinit var binding: LayoutRowBinding;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        binding = LayoutRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataHolder(binding);
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val response: DataResponse = listData[position]
        holder.setData(response.row[position])
    }

    inner class DataHolder(private val binding: LayoutRowBinding): RecyclerView.ViewHolder(binding.root) {

        fun setData(model: Row) {
            with(binding) {
                executePendingBindings()
            }
        }
    }
}