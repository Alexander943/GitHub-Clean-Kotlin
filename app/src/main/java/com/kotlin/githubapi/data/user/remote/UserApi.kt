package com.kotlin.githubapi.data.user.remote

import com.kotlin.githubapi.data.user.response.Users
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("/search/users")
    fun getUsers(@Query("page") page: Int?,
                 @Query("per_page") perPage: Int?,
                 @Query("q") query: String): Observable<Users>
}