package com.evren.github.repository

import com.evren.github.data.model.repositories.OwnerResponse
import com.evren.github.data.model.repositories.RepositoriesItemResponse
import com.evren.github.data.remote.RemoteGithubDataSource
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val remoteGithubDataSource: RemoteGithubDataSource
) {
    suspend fun getAllRepositories() = remoteGithubDataSource.getAllRepositories()

    suspend fun getRepository(repositoryName: String,ownerName: String): RepositoriesItemResponse = remoteGithubDataSource.getRepository(repositoryName,ownerName)

    suspend fun getOwnerRepos(userName: String): List<RepositoriesItemResponse> = remoteGithubDataSource.getOwnerRepos(userName)

    suspend fun getOwner(userName: String): OwnerResponse = remoteGithubDataSource.getOwner(userName)
}