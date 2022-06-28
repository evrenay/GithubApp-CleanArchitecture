package com.evren.github.ui.owner

import androidx.recyclerview.widget.DiffUtil
import com.evren.github.ui.repositories.RepositoriesItemUiState

class OwnerRepositoriesDiffUtil (
    private val oldRepositoriesList: List<OwnerRepositoriesUiState>,
    private val newRepositoriesList: List<OwnerRepositoriesUiState>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldRepositoriesList.size

    override fun getNewListSize(): Int = newRepositoriesList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return  oldRepositoriesList[oldItemPosition] == newRepositoriesList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldRepositoriesList[oldItemPosition] == newRepositoriesList[newItemPosition]
    }

}