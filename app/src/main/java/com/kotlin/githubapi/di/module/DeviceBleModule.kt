package com.strikepros.alphaone.di.module

import android.app.Application
import com.polidea.rxandroidble2.RxBleClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DeviceBleModule {

    @Provides
    @Singleton
    internal fun provideRxBleClient(application: Application): RxBleClient {
        return RxBleClient.create(application)
    }
}