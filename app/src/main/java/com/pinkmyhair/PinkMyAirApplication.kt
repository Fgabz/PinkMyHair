package com.pinkmyhair

import android.app.Application
import com.pinkmyhair.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class PinkMyAirApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .application(this)
            .context(this.applicationContext)
            .build()
            .inject(this)

        Timber.plant(Timber.DebugTree())
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}