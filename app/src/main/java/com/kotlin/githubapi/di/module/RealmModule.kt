package com.strikepros.alphaone.di.module

import com.strikepros.alphaone.di.annotation.realm.RealmEncrypted
import com.strikepros.alphaone.di.annotation.realm.RealmGlobal
import com.strikepros.alphaone.di.annotation.realm.RealmInMemory
import dagger.Module
import dagger.Provides
import io.realm.RealmConfiguration
import javax.inject.Singleton

/**
 * Created on 14.03.2018.
 */

@Module
class RealmModule {

    @Singleton
    @Provides
    @RealmGlobal
    internal fun provideRealmGlobal(): RealmConfiguration {
        return RealmConfiguration.Builder()
                .name("AppGlobal.realm")
                .deleteRealmIfMigrationNeeded()
                .build()
    }

    @Singleton
    @Provides
    @RealmEncrypted
    internal fun provideRealmEncrypted(): RealmConfiguration {
        val key = ByteArray(64)
        key[0] = 1
        return RealmConfiguration.Builder()
                .name("AppEncrypted.realm")
                .deleteRealmIfMigrationNeeded()
                .encryptionKey(key)
                .build()
    }

    @Singleton
    @Provides
    @RealmInMemory
    internal fun provideRealmInMemory(): RealmConfiguration {
        return RealmConfiguration.Builder()
                .name("AppInMemory.realm")
                .deleteRealmIfMigrationNeeded()
                .inMemory()
                .build()
    }

}