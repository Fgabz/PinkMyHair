package com.pinkmyhair.feature.picturetopink

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinkmyhair.annotation.PerActivity
import com.pinkmyhair.domain.UploadAvatarUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream
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

    fun onPhotoPicked(imageUri: InputStream?, mediaType: String?) = viewModelScope.launch(Dispatchers.IO) {
        imageUri?.let {
            uploadAvatarUseCase.uploadAvatar(it, mediaType)
        }
    }
}