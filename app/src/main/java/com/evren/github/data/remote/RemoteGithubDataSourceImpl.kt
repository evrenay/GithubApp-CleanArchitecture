package com.evren.github.data.remote

import com.evren.github.data.api.GithubService
import com.evren.github.data.di.IoDispatcher
import com.evren.github.data.model.repositories.OwnerResponse
import com.evren.github.data.model.repositories.RepositoriesItemResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteGithubDataSourceImpl @Inject constructor(
    private val service: GithubService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : RemoteGithubDataSource {


    override suspend fun getAllRepositories() = withContext(dispatcher) {
        service.getAllRepositories()
    }

    override suspend fun getRepository(repositoryName: String,ownerName: String): RepositoriesItemResponse = withContext(dispatcher) {
        service.getRepository(repositoryName,ownerName)
    }

    override suspend fun getOwnerRepos(userName: String): List<RepositoriesItemResponse> = withContext(dispatcher) {
        service.getOwnerRepos(userName)
    }

    override suspend fun getOwner(userName: String): OwnerResponse = withContext(dispatcher) {
        service.getOwner(userName)
    }
}