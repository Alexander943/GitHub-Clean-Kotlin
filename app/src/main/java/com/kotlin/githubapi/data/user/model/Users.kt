package com.kotlin.githubapi.data.user.model

import com.google.gson.annotations.SerializedName

data class Users(
        @SerializedName("incomplete_results")
        var incompleteResults: Boolean?,
        @SerializedName("items")
        var items: List<User?>?,
        @SerializedName("total_count")
        var totalCount: Int?
)