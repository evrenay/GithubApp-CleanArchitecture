package com.evren.github.ui.repositories

import com.evren.github.base.BaseUiViewState
import com.evren.github.data.model.repositories.RepositoriesItemResponse

class RepositoriesItemUiState(private val repositoriesItemResponse: RepositoriesItemResponse) : BaseUiViewState() {

    fun getImageUrl() = repositoriesItemResponse.owner?.avatarUrl

    fun getRepoName() = repositoriesItemResponse.name

    fun getOwnerName() = repositoriesItemResponse.owner?.userName

    fun getUserName() = "@"+repositoriesItemResponse.owner?.userName

}