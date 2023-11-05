package com.example.googleplayappui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainRecyclerView = findViewById<RecyclerView>(R.id.mainRecyclerView)
        mainRecyclerView.layoutManager = LinearLayoutManager(this)

        val data = generateData()
        val mainAdapter = MainAdapter(data)
        mainRecyclerView.adapter = mainAdapter

        val categoryRecyclerView = findViewById<RecyclerView>(R.id.categoryRecyclerView)

        // Tạo danh sách danh mục
        val categories = listOf(
            "Cho bạn",
            "Bảng xếp hạng",
            "Trẻ em",
            "Có tính phí",
            "Loại",
        )

        // Thiết lập Adapter cho Horizontal RecyclerView
        val categoryAdapter = CategoryAdapter(categories)
        categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryRecyclerView.adapter = categoryAdapter
    }

    private fun generateData(): List<List<Model>> {
        val data = mutableListOf<List<Model>>()
        for (i in 1..10) {
            val subList = (1..5).map {
                Model("App $i-$it",4.5f ,R.drawable.ic_launcher_foreground)
            }
            data.add(subList)
        }
        return data
    }
}



