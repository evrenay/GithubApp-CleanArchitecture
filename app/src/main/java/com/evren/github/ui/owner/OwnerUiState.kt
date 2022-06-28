package com.evren.github.ui.owner

import com.evren.github.base.BaseUiViewState
import com.evren.github.data.model.repositories.OwnerResponse

class OwnerUiState (private val ownerResponse: OwnerResponse) : BaseUiViewState() {

    fun getImageUrl() = ownerResponse.avatarUrl

    fun getOwnerUserName() = "@"+ownerResponse.userName

}