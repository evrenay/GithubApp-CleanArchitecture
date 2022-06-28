package com.evren.github.ui.owner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evren.github.base.StatusViewState
import com.evren.github.common.doOnStatusChanged
import com.evren.github.common.doOnSuccess
import com.evren.github.domain.usecase.GetAllRepositoriesUseCase
import com.evren.github.domain.usecase.GetOwnerRepositoriesUseCase
import com.evren.github.domain.usecase.GetOwnerUseCase
import com.evren.github.domain.usecase.GetRepositoryUseCase
import com.evren.github.ui.repositories.RepositoriesItemUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OwnerRepositoriesViewModel @Inject constructor(
    private val getOwnerUseCase: GetOwnerUseCase,
    private val getOwnerRepositoriesUseCase: GetOwnerRepositoriesUseCase
) : ViewModel() {


    private val ownerRepositoriesContents = MutableLiveData<List<OwnerRepositoriesUiState>>()
    val ownerRepositoriesContents_: LiveData<List<OwnerRepositoriesUiState>> = ownerRepositoriesContents

    private val ownerRepositoriesStatus = MutableLiveData<StatusViewState>()
    val ownerRepositoriesStatus_: LiveData<StatusViewState> = ownerRepositoriesStatus

    private val ownerContents = MutableLiveData<OwnerUiState>()
    val ownerContents_: LiveData<OwnerUiState> = ownerContents

    private val ownerStatus = MutableLiveData<StatusViewState>()
    val ownerStatus_: LiveData<StatusViewState> = ownerStatus



    private fun getOwner(userName: String)  {
            getOwnerUseCase.getOwner(userName).doOnSuccess { data ->
                ownerContents.value = OwnerUiState(data)
            }.doOnStatusChanged {
                ownerStatus.value = StatusViewState(status = it)
            }.launchIn(viewModelScope)
        }


    private fun getOwnerRepositories(userName: String) {
            getOwnerRepositoriesUseCase.getOwnerRepositories(userName).doOnSuccess { data ->
                ownerRepositoriesContents.value = data.map { repositoriesItemResponse -> OwnerRepositoriesUiState(repositoriesItemResponse) }
            }.doOnStatusChanged {
                ownerRepositoriesStatus.value = StatusViewState(status = it)
            }.launchIn(viewModelScope)
        }

    fun getDataAsynchronously(userName: String){
            getOwnerRepositories(userName)
            getOwner(userName)

    }



}