package com.kotlin.githubapi.di

import android.app.Application
import com.kotlin.githubapi.app.App
import com.kotlin.githubapi.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * This is a Dagger component. Refer to [com.strikepros.alphaone.App] for the list of Dagger components
 * used in this application.
 *
 *
 * Even though Dagger allows annotating a [Component] as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in [com.strikepros.alphaone.App].
 * //[AndroidSupportInjectionModule]
 * // is the module from Dagger.Android that helps with the generation
 * // and location of subcomponents.
 */

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityModule::class,
    FragmentModule::class,
    ViewModelModule::class,
    NetworkClientModule::class,
    NetworkApiModule::class,
    RetrofitModule::class,
    RealmModule::class,
    DataSourceModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}