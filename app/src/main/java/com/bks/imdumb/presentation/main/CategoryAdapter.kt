package com.bks.imdumb.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bks.imdumb.databinding.ItemCategoryBinding
import com.bks.imdumb.domain.model.MovieCategory

class CategoryAdapter(
    private val viewPool: RecyclerView.RecycledViewPool,
    private val onMovieClick: (com.bks.imdumb.domain.model.Movie) -> Unit
) : ListAdapter<MovieCategory, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: MovieCategory) {
            binding.tvCategoryName.text = category.name
            
            val movieAdapter = MovieAdapter(onMovieClick)
            binding.rvMovies.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = movieAdapter
                setRecycledViewPool(viewPool)
            }
            movieAdapter.submitList(category.movies)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<MovieCategory>() {
        override fun areItemsTheSame(oldItem: MovieCategory, newItem: MovieCategory): Boolean = oldItem.name == newItem.name
        override fun areContentsTheSame(oldItem: MovieCategory, newItem: MovieCategory): Boolean = oldItem == newItem
    }
}
