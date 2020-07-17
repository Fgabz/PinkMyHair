package com.pinkmyhair.feature.picturetopink.di

import androidx.lifecycle.ViewModel
import com.pinkmyhair.annotation.ViewModelKey
import com.pinkmyhair.domain.UploadAvatarUseCase
import com.pinkmyhair.feature.picturetopink.EditPhotoInteractor
import com.pinkmyhair.feature.picturetopink.EditPhotoPresenter
import com.pinkmyhair.feature.picturetopink.EditPhotoViewController
import com.pinkmyhair.feature.picturetopink.IEditPhotoPresenter
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class EditPictureModule {
    @Binds
    abstract fun providePresenter(presenter: EditPhotoPresenter): IEditPhotoPresenter

    @Binds
    abstract fun provideInteractor(interactor: EditPhotoInteractor): UploadAvatarUseCase

    @Binds
    @IntoMap
    @ViewModelKey(EditPhotoViewController::class)
    abstract fun bindToDoViewModel(viewModel: EditPhotoViewController): ViewModel
}