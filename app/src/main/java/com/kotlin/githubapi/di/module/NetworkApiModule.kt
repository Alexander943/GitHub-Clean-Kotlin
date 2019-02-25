package com.strikepros.alphaone.di.module

import com.strikepros.alphaone.data.account.remote.AccountApi
import com.strikepros.alphaone.data.auth.remote.AuthApi
import com.strikepros.alphaone.data.freeforall.remote.FreeForAllApi
import com.strikepros.alphaone.data.location.remote.LocationApi
import com.strikepros.alphaone.data.player.remote.PlayerApi
import com.strikepros.alphaone.data.playeractivity.remote.PlayerActivityApi
import com.strikepros.alphaone.data.pushnotification.remote.PushNotificationApi
import com.strikepros.alphaone.data.register.remote.RegisterApi
import com.strikepros.alphaone.data.teambattle.remote.TeamBattleApi
import com.strikepros.alphaone.di.annotation.retrofit.RetrofitDefault
import com.strikepros.alphaone.di.annotation.retrofit.RetrofitLogging

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created on 13.03.2018.
 */

@Module
class NetworkApiModule {

    @Provides
    internal fun provideLocationApi(@RetrofitDefault retrofit: Retrofit): LocationApi {
        return retrofit.create(LocationApi::class.java)
    }

    @Provides
    internal fun provideRegisterApi(@RetrofitLogging retrofit: Retrofit): RegisterApi {
        return retrofit.create(RegisterApi::class.java)
    }

    @Provides
    internal fun provideAuthApi(@RetrofitLogging retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    internal fun provideAccountApi(@RetrofitLogging retrofit: Retrofit): AccountApi {
        return retrofit.create(AccountApi::class.java)
    }

    @Provides
    internal fun provideFreeForAllApi(@RetrofitLogging retrofit: Retrofit): FreeForAllApi {
        return retrofit.create(FreeForAllApi::class.java)
    }

    @Provides
    internal fun providePushNotificationApi(@RetrofitLogging retrofit: Retrofit): PushNotificationApi {
        return retrofit.create(PushNotificationApi::class.java)
    }

    @Provides
    internal fun provideTeamBattleApi(@RetrofitLogging retrofit: Retrofit): TeamBattleApi {
        return retrofit.create(TeamBattleApi::class.java)
    }

    @Provides
    internal fun providePlayerActivityApi(@RetrofitLogging retrofit: Retrofit): PlayerActivityApi {
        return retrofit.create(PlayerActivityApi::class.java)
    }

    @Provides
    internal fun providePlayerApi(@RetrofitLogging retrofit: Retrofit): PlayerApi {
        return retrofit.create(PlayerApi::class.java)
    }

}