package com.kotlin.githubapi.ui.usersearch

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.kotlin.githubapi.data.user.parameter.SearchUserParameters
import com.kotlin.githubapi.data.user.response.User
import com.kotlin.githubapi.domain.user.GetUsersUseCase
import io.reactivex.disposables.CompositeDisposable

class UserSearchDataSourceFactory(private val parameters: SearchUserParameters,
                                  private val getUsersUseCase: GetUsersUseCase,
                                  private val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<SearchUserParameters, List<User>>() {

    val userDataSourceLiveData = MutableLiveData<UserSearchDataSource>()

    override fun create(): DataSource<SearchUserParameters, List<User>> {
        val taskDataSource = UserSearchDataSource(parameters, getUsersUseCase, compositeDisposable)
        userDataSourceLiveData.postValue(taskDataSource)
        return taskDataSource
    }

    fun start(parameters: SearchUserParameters) {
        if (this.parameters == parameters) return
        //        this.parameters.setCategories(parameters.getCategories());
        //        this.parameters.setLatitude(parameters.getLatitude());
        //        this.parameters.setLongitude(parameters.getLongitude());
        //        this.parameters.setRadius(parameters.getRadius());
        //        this.parameters.setForMap(parameters.getForMap());
        //        this.parameters.setSort(parameters.getSort());
        //        this.parameters.setFilter(parameters.getFilter());
        //        this.parameters.setPerPage(parameters.getPerPage());
        //        this.parameters.setPage(1);
        userDataSourceLiveData.value?.invalidate()
    }

    fun refresh() {
        userDataSourceLiveData.value?.invalidate()
    }
}

