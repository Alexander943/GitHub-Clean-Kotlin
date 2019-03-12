package com.kotlin.githubapi.data.user.remote

import com.kotlin.githubapi.data.user.response.Users
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSource
@Inject
constructor(private val api: UserApi) {

    fun getUsers(page: Int?, perPage: Int?, query: String): Observable<Users> {
        return api.getUsers(page, perPage, query)
    }
}