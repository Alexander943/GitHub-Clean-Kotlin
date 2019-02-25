package com.strikepros.alphaone.di.module

import android.app.Application
import android.content.Context
import android.location.LocationManager
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationSettingsRequest
import com.strikepros.alphaone.di.annotation.location.LocationInfinite
import com.strikepros.alphaone.di.annotation.location.LocationOnce
import dagger.Module
import dagger.Provides
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider
import pl.charmas.android.reactivelocation2.ReactiveLocationProviderConfiguration

/**
 * Created by on 11.04.18.
 */
@Module
class LocationModule {

    @Provides
    @LocationOnce
    internal fun provideLocationOneRequest(): LocationRequest =
            LocationRequest.create()
                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                    .setNumUpdates(1)
                    .setInterval(100)

    @Provides
    @LocationInfinite
    internal fun provideLocationInfiniteRequest(): LocationRequest =
            LocationRequest.create()
                    .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                    .setInterval(1000)

    @Provides
    internal fun provideReactiveLocation(application: Application): ReactiveLocationProvider =
            ReactiveLocationProvider(application.applicationContext, ReactiveLocationProviderConfiguration
                    .builder()
                    .setRetryOnConnectionSuspended(true)
                    .build()
            )

    @Provides
    internal fun provideLocationManager(application: Application): LocationManager =
            application.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @Provides
    internal fun provideLocationSettingsRequest(@LocationOnce locationOnce: LocationRequest,
                                                @LocationInfinite locationInfinite: LocationRequest): LocationSettingsRequest =
            LocationSettingsRequest.Builder()
                    .addLocationRequest(locationOnce)
                    .addLocationRequest(locationInfinite)
                    .build()


}