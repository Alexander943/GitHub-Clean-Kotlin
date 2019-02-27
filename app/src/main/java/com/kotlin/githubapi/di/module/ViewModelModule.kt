package com.kotlin.githubapi.di.module

import androidx.lifecycle.ViewModelProvider
import com.kotlin.githubapi.ui.base.AppViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(SplashViewModel::class)
//    internal abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel
}
