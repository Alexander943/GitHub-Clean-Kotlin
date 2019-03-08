package com.kotlin.githubapi.data.user

import com.kotlin.githubapi.data.user.model.Users
import io.reactivex.Observable

interface UserDataSource {

    fun getUsers(query: String): Observable<Users>
}