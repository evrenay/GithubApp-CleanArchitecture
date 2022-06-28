package com.evren.github.data.model.repositories

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize


@JsonClass(generateAdapter = true)
@Parcelize
data class RepositoriesItemResponse(
    val description: String?,
    @field:Json(name = "full_name")
    val fullName: String?,
    val id: Int?,
    val name: String?,
    val owner: OwnerResponse?,
    val url: String?,
    @field:Json(name = "forks_count")
    val forksCount: Int?,
    val language : String?,
    @field:Json(name = "default_branch")
    val defaultBranchName : String?
) : Parcelable