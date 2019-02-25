package com.kotlin.githubapi.di.module

import com.kotlin.githubapi.ui.main.MainActivity
import com.kotlin.githubapi.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun splashActivity(): SplashActivity

    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity

}