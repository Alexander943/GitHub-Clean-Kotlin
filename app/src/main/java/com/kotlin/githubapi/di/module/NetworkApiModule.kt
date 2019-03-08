package com.kotlin.githubapi.di.module

import com.kotlin.githubapi.data.user.remote.UserApi
import com.kotlin.githubapi.di.annotation.retrofit.RetrofitLogging
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkApiModule {

    @Provides
    internal fun provideUserApi(@RetrofitLogging retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }
}