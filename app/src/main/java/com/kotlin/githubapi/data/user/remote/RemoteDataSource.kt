package com.kotlin.githubapi.data.user.remote

import com.kotlin.githubapi.data.user.model.Users
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSource
@Inject
constructor(private val api: UserApi) {

    fun getUsers(query: String): Observable<Users> {
        return api.getUsers(query)
    }
}