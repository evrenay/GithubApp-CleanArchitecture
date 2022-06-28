package com.evren.github.ui.repositories

import androidx.recyclerview.widget.DiffUtil

class RepositoriesDiffUtil (
    private val oldRepositoriesList: List<RepositoriesItemUiState>,
    private val newRepositoriesList: List<RepositoriesItemUiState>
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