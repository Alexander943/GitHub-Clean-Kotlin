package com.kotlin.githubapi.data.user

import com.kotlin.githubapi.data.user.remote.RemoteDataSource
import com.kotlin.githubapi.data.user.response.Users
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository
@Inject
constructor(private val remoteDataSource: RemoteDataSource) : UserDataSource {

    override fun getUsers(page: Int?, perPage: Int?, query: String): Observable<Users> {
        return remoteDataSource.getUsers(page, perPage, query)
    }
}