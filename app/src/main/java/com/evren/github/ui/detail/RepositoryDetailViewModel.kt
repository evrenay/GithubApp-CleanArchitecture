package com.evren.github.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evren.github.base.StatusViewState
import com.evren.github.common.doOnStatusChanged
import com.evren.github.common.doOnSuccess
import com.evren.github.domain.usecase.GetRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class RepositoryDetailViewModel @Inject constructor(
    private val getRepositoryUseCase: GetRepositoryUseCase
) : ViewModel() {

    var ownerName: String ?= null

    private val contents = MutableLiveData<RepositoryUiState>()
    val contents_: LiveData<RepositoryUiState> = contents

    private val status = MutableLiveData<StatusViewState>()
    val status_: LiveData<StatusViewState> = status



    fun getRepository(repositoryName : String,ownerName: String) {
        getRepositoryUseCase
            .getRepository(repositoryName,ownerName)
            .doOnSuccess { data ->
                contents.value = RepositoryUiState(data)
            }
            .doOnStatusChanged {
                status.value = StatusViewState(status = it)
            }
            .launchIn(viewModelScope)
    }



}