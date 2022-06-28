package com.evren.github.domain.usecase

import com.evren.github.common.Resource
import com.evren.github.data.di.IoDispatcher
import com.evren.github.repository.GithubRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetAllRepositoriesUseCase @Inject constructor(
    private val repository: GithubRepository,
    @IoDispatcher val dispatcher: CoroutineDispatcher
) {
    fun getAllRepositories() = flow {
        emit(Resource.Loading)
        val repositories = repository.getAllRepositories()
        emit(Resource.Success(repositories))
    }.catch {
        emit(Resource.Error(it))
    }.flowOn(dispatcher)
}