package com.kotlin.githubapi.di.module

import com.kotlin.githubapi.data.user.UserDataSource
import com.kotlin.githubapi.data.user.UserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    internal abstract fun provideUserDataSource(userRepository: UserRepository): UserDataSource
}