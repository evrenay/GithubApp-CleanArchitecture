package com.evren.github.ui.owner

import androidx.recyclerview.widget.RecyclerView
import com.evren.github.databinding.ItemOwnerRepositoriesBinding
import com.evren.github.util.ext.executeWithAction

class OwnerRepositoriesViewHolder(private val binding: ItemOwnerRepositoriesBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: OwnerRepositoriesUiState) {
        binding.executeWithAction {
            ownerRepositoriesUiState = item
        }
    }
}