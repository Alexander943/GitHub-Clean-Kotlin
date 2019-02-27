package com.kotlin.githubapi.di.module

import com.kotlin.githubapi.BuildConfig
import com.kotlin.githubapi.di.annotation.httpclient.ClientDefault
import com.kotlin.githubapi.di.annotation.httpclient.ClientLogging
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkClientModule {

    @Singleton
    @Provides
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    internal fun provideCurlLogginInterceptor(): CurlLoggerInterceptor {
        return CurlLoggerInterceptor()
    }

    @Singleton
    @Provides
    @ClientLogging
    internal fun provideHttpClientLogging(logging: HttpLoggingInterceptor,
                                          curl: CurlLoggerInterceptor): OkHttpClient {
        val TIMEOUT_SEC: Long = 20

        val builder = OkHttpClient.Builder()
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .connectTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(curl)
            builder.addInterceptor(logging)
        }

        return builder.build()
    }

    @Singleton
    @Provides
    @ClientDefault
    internal fun provideHttpClientDefault(): OkHttpClient {
        val TIMEOUT_SEC: Long = 20

        val builder = OkHttpClient.Builder()
                .followRedirects(true)
                .followSslRedirects(true)
                .retryOnConnectionFailure(true)
                .connectTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_SEC, TimeUnit.SECONDS)

        return builder.build()
    }
}
