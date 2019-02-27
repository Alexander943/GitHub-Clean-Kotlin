package com.kotlin.githubapi.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kotlin.githubapi.BuildConfig
import com.kotlin.githubapi.di.annotation.httpclient.ClientDefault
import com.kotlin.githubapi.di.annotation.httpclient.ClientLogging
import com.kotlin.githubapi.di.annotation.retrofit.RetrofitDefault
import com.kotlin.githubapi.di.annotation.retrofit.RetrofitLogging
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Singleton
    @Provides
    internal fun provideGson(): Gson {
        return GsonBuilder()
                .setLenient()
                .create()
    }

    @Singleton
    @Provides
    internal fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    @RetrofitLogging
    internal fun provideRetrofitLogging(@ClientLogging client: OkHttpClient,
                                        gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(SchedulersFacade.io()))
                .client(client)
                .build()
    }

    @Singleton
    @Provides
    @RetrofitDefault
    internal fun provideRetrofitDefault(@ClientDefault client: OkHttpClient,
                                        gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(SchedulersFacade.io()))
                .client(client)
                .build()
    }

}