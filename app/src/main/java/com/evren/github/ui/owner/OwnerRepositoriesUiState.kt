package com.evren.github.ui.owner

import com.evren.github.base.BaseUiViewState
import com.evren.github.data.model.repositories.RepositoriesItemResponse

class OwnerRepositoriesUiState(private val repositoriesItemResponse: RepositoriesItemResponse) : BaseUiViewState() {

    fun getRepoName() = repositoriesItemResponse.name

    fun getRepoDescription() = repositoriesItemResponse.description

    fun getLanguage() = repositoriesItemResponse.language

}