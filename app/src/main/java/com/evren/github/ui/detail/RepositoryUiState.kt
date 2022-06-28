package com.evren.github.ui.detail

import com.evren.github.base.BaseUiViewState
import com.evren.github.data.model.repositories.RepositoriesItemResponse

class RepositoryUiState (private val repositoriesItemResponse: RepositoriesItemResponse) : BaseUiViewState() {

    fun getImageUrl() = repositoriesItemResponse.owner?.avatarUrl

    fun getRepoName() = repositoriesItemResponse.name

    fun getOwnerUserName() = "@"+repositoriesItemResponse.owner?.userName

    fun getForkCount() = repositoriesItemResponse.forksCount.toString()

    fun getLanguage() = repositoriesItemResponse.language

    fun getDefaultBranchName() = repositoriesItemResponse.defaultBranchName

}