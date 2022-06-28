package com.evren.github.domain.usecase

import com.evren.github.common.Resource
import com.evren.github.data.di.IoDispatcher
import com.evren.github.repository.GithubRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetOwnerUseCase @Inject constructor(
    private val repository: GithubRepository,
    @IoDispatcher val dispatcher: CoroutineDispatcher
) {
    fun getOwner(userName : String) = flow {
        emit(Resource.Loading)
        val repositories = repository.getOwner(userName)
        emit(Resource.Success(repositories))
    }.catch {
        emit(Resource.Error(it))
    }.flowOn(dispatcher)
}