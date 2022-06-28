package com.evren.github.ui.repositories

import androidx.recyclerview.widget.RecyclerView
import com.evren.github.databinding.ItemRepositoriesBinding
import com.evren.github.util.ext.executeWithAction

class RepositoriesViewHolder(private val binding: ItemRepositoriesBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: RepositoriesItemUiState, onRepositoryClicked: (selectedRepository : RepositoriesItemUiState) -> Unit) {
        binding.executeWithAction {
            repositoriesItemUiState = item
        }
        binding.repositoryContainer.setOnClickListener {
            onRepositoryClicked(item)
        }
    }
}