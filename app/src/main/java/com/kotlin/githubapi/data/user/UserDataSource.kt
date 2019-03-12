package com.kotlin.githubapi.data.user

import com.kotlin.githubapi.data.user.response.Users
import io.reactivex.Observable

interface UserDataSource {

    fun getUsers(page: Int?, perPage: Int?, query: String): Observable<Users>
}