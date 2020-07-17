package com.pinkmyhair.feature.picturetopink

import androidx.lifecycle.ViewModel
import com.pinkmyhair.annotation.PerActivity
import com.pinkmyhair.domain.UploadAvatarUseCase
import javax.inject.Inject

@PerActivity
class EditPhotoViewController @Inject constructor(
    private val uploadAvatarUseCase: UploadAvatarUseCase,
    private val presenter: IEditPhotoPresenter
) : ViewModel(), IEditPhotoView {

    fun onCreate() {
        presenter.onAttachView(this)
    }

    override fun onCleared() {
        presenter.onDetachView()
        super.onCleared()
    }

}