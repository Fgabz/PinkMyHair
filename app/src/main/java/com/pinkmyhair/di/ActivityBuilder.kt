package com.pinkmyhair.di

import com.pinkmyhair.annotation.PerActivity
import com.pinkmyhair.feature.picturetopink.EditPhotoActivity
import com.pinkmyhair.feature.picturetopink.di.EditPictureModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            EditPictureModule::class
        ]
    )
    abstract fun contributeHomeActivityInjector(): EditPhotoActivity
}