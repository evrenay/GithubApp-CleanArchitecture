package com.evren.github.data.model.repositories

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class OwnerResponse(
    @field:Json(name = "avatar_url")
    val avatarUrl: String?,
    @field:Json(name = "login")
    val userName: String?,
    val id: Int?,
) : Parcelable