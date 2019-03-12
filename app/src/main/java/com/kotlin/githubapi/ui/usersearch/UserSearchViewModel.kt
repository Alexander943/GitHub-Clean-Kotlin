package com.kotlin.githubapi.ui.usersearch

import androidx.lifecycle.MutableLiveData
import com.kotlin.githubapi.app.extension.threadManageIoToUi
import com.kotlin.githubapi.data.user.parameter.SearchUserParameters
import com.kotlin.githubapi.data.user.response.User
import com.kotlin.githubapi.domain.user.GetUsersUseCase
import com.kotlin.githubapi.ui.base.BaseViewModel
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import javax.inject.Inject

class UserSearchViewModel
@Inject
constructor(private val getUsersUseCase: GetUsersUseCase) : BaseViewModel() {

    val users = MutableLiveData<List<User?>>()

    fun loadUsers(query: String) {
        compositeDisposable.add(getUsersUseCase
                .run(SearchUserParameters(q = query))
                .threadManageIoToUi()
                .subscribeBy(
                        onNext = { users.postValue(it.items) },
                        onError = { Timber.e(it) }
                ))
    }
}