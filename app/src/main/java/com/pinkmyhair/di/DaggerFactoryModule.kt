package com.pinkmyhair.annotation

import dagger.Binds
import dagger.Module

@Module
abstract class DaggerFactoryModule {

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: DaggerViewModelFactory): IDaggerFactoryViewModel
}