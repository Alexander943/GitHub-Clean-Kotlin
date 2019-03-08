package com.kotlin.githubapi.domain.user

import com.kotlin.githubapi.data.user.UserDataSource
import com.kotlin.githubapi.data.user.model.Users
import com.kotlin.githubapi.domain.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetUsersUseCase
@Inject
constructor(private val dataSource: UserDataSource) : UseCase<String, Users>() {

    override fun executeUseCase(query: String): Observable<Users> {
        return dataSource.getUsers(query)
    }
}