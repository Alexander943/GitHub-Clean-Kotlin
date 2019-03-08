package com.kotlin.githubapi.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.githubapi.di.annotation.ViewModelKey
import com.kotlin.githubapi.ui.base.AppViewModelFactory
import com.kotlin.githubapi.ui.usersearch.UserSearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(UserSearchViewModel::class)
    internal abstract fun bindUserSearchViewModel(userSearchViewModel: UserSearchViewModel): ViewModel
}
