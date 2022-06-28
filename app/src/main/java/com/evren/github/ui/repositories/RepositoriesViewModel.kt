package com.evren.github.ui.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evren.github.base.StatusViewState
import com.evren.github.common.doOnStatusChanged
import com.evren.github.common.doOnSuccess
import com.evren.github.domain.usecase.GetAllRepositoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val getAllRepositoriesUseCase: GetAllRepositoriesUseCase
) : ViewModel() {


    private val contents = MutableLiveData<List<RepositoriesItemUiState>>()
    val contents_: LiveData<List<RepositoriesItemUiState>> = contents

    private val status = MutableLiveData<StatusViewState>()
    val status_: LiveData<StatusViewState> = status

    init {
        getAllRepositories()
    }

    private fun getAllRepositories() {
        getAllRepositoriesUseCase
            .getAllRepositories()
            .doOnSuccess { data ->
                contents.value = data.map { repositoriesItemResponse -> RepositoriesItemUiState(repositoriesItemResponse) }
            }
            .doOnStatusChanged {
                status.value = StatusViewState(status = it)
            }
            .launchIn(viewModelScope)
    }



}