package com.evren.github.ui.repositories

data class RepositoriesCallbacks(
    val onRepositoryClicked : (selectedRepository : RepositoriesItemUiState) -> Unit
)