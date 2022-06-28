package com.evren.github.data.remote

import com.evren.github.data.model.repositories.OwnerResponse
import com.evren.github.data.model.repositories.RepositoriesItemResponse

interface RemoteGithubDataSource {
    suspend fun getAllRepositories() : List<RepositoriesItemResponse>
    suspend fun getRepository(repositoryName : String,ownerName: String) : RepositoriesItemResponse
    suspend fun getOwnerRepos(userName: String): List<RepositoriesItemResponse>
    suspend fun getOwner(userName: String): OwnerResponse
}