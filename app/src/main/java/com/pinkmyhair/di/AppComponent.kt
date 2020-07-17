package com.pinkmyhair.di

import android.app.Application
import android.content.Context
import com.pinkmyhair.PinkMyAirApplication
import com.pinkmyhair.annotation.DaggerFactoryModule
import com.pinkmyhair.annotation.PerApp
import com.pinkmyhair.repository.di.RepositoryModule
import com.pinkmyhair.service.RemoteModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@PerApp
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        RemoteModule::class,
        RepositoryModule::class,
        DaggerFactoryModule::class]
)
interface AppComponent {

    fun inject(application: PinkMyAirApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}