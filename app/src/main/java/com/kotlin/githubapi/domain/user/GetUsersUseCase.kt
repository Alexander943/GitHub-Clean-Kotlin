package com.kotlin.githubapi.domain.user

import com.kotlin.githubapi.data.user.UserDataSource
import com.kotlin.githubapi.data.user.parameter.SearchUserParameters
import com.kotlin.githubapi.data.user.response.Users
import com.kotlin.githubapi.domain.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetUsersUseCase
@Inject
constructor(private val dataSource: UserDataSource) : UseCase<SearchUserParameters, Users>() {

    override fun executeUseCase(requestValues: SearchUserParameters): Observable<Users> {
        return dataSource.getUsers(
                requestValues.page,
                requestValues.per_page,
                requestValues.q)
    }
}