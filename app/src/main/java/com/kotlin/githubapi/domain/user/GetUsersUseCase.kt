package com.kotlin.githubapi.domain.user

import com.kotlin.githubapi.data.user.UserDataSource
import com.kotlin.githubapi.domain.Empty
import com.kotlin.githubapi.domain.UseCase
import io.reactivex.Observable
import javax.inject.Inject

class GetUsersUseCase
@Inject
constructor(private val dataSource: UserDataSource) : UseCase<Empty, Empty>() {

    override fun executeUseCase(requestValues: Empty): Observable<Empty> {
        return Observable.empty()
    }
}