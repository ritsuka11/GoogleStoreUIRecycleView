package com.example.googleplayappui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {
    private var apps: List<Model> = emptyList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val appImageView: ImageView = itemView.findViewById(R.id.appImageView)
        val appNameTextView: TextView = itemView.findViewById(R.id.appNameTextView)
        val appRatingTextView: TextView = itemView.findViewById(R.id.appRatingTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_horizontal, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val app = apps[position]
        holder.appImageView.setImageResource(app.appImage)
        holder.appNameTextView.text = app.name
        val ratingText = "${app.rating} *"
        holder.appRatingTextView.text = ratingText
    }

    override fun getItemCount() = apps.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData: List<Model>) {
        apps = newData
        notifyDataSetChanged()
    }
}
