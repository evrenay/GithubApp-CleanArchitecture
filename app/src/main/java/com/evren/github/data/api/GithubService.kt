package com.evren.github.data.api

import com.evren.github.data.model.repositories.OwnerResponse
import com.evren.github.data.model.repositories.RepositoriesItemResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("repositories")
    suspend fun getAllRepositories(
    ): List<RepositoriesItemResponse>

    @GET("repos/{ownerName}/{repoName}")
    suspend fun getRepository(
        @Path("repoName") repoName: String,
        @Path("ownerName") ownerName: String
    ): RepositoriesItemResponse

    @GET("users/{userName}/repos")
    suspend fun getOwnerRepos(@Path("userName") userName: String): List<RepositoriesItemResponse>

    @GET("users/{userName}")
    suspend fun getOwner(@Path("userName") userName: String): OwnerResponse
}