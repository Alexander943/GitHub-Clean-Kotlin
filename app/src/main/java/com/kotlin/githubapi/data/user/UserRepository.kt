package com.kotlin.githubapi.data.user

import com.kotlin.githubapi.data.user.model.Users
import com.kotlin.githubapi.data.user.remote.RemoteDataSource
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository
@Inject
constructor(private val remoteDataSource: RemoteDataSource) : UserDataSource {

    override fun getUsers(query: String): Observable<Users> {
        return remoteDataSource.getUsers(query)
    }
}