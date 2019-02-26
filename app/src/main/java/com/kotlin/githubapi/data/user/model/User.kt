package com.kotlin.githubapi.data.user.model

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("avatar_url")
        var avatarUrl: String?,
        @SerializedName("followers_url")
        var followersUrl: String?,
        @SerializedName("gravatar_id")
        var gravatarId: String?,
        @SerializedName("html_url")
        var htmlUrl: String?,
        @SerializedName("id")
        var id: Int?,
        @SerializedName("login")
        var login: String?,
        @SerializedName("node_id")
        var nodeId: String?,
        @SerializedName("organizations_url")
        var organizationsUrl: String?,
        @SerializedName("received_events_url")
        var receivedEventsUrl: String?,
        @SerializedName("repos_url")
        var reposUrl: String?,
        @SerializedName("score")
        var score: Double?,
        @SerializedName("subscriptions_url")
        var subscriptionsUrl: String?,
        @SerializedName("type")
        var type: String?,
        @SerializedName("url")
        var url: String?
)