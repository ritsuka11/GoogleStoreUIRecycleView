package com.example.googleplayappui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val data: List<List<Model>>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val horizontalRecyclerView: RecyclerView = itemView.findViewById(R.id.horizontalRecyclerView)
        val horizontalAdapter = HorizontalAdapter()

        init {
            horizontalRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            horizontalRecyclerView.adapter = horizontalAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.horizontalAdapter.setData(data[position])
    }

    override fun getItemCount() = data.size
}