package com.pinkmyhair.repository.di

import com.pinkmyhair.repository.AvatarDatasource
import com.pinkmyhair.repository.AvatarRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideUSerRepo(userRepository: AvatarRepository): AvatarDatasource
}