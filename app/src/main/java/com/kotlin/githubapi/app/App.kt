package com.kotlin.githubapi.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return AndroidInjector {
            //
        }
//        return DaggerAppComponent.builder().application(this).build()
    }
}