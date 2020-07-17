package com.pinkmyhair.feature.picturetopink

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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


    private val _livedataTransformedImage = MutableLiveData<Bitmap>()
    private val _livedataError= MutableLiveData<String>()


    val livedataTransformedImage: LiveData<Bitmap> = _livedataTransformedImage
    val livedataError: LiveData<String> = _livedataError

    fun onCreate() {
        presenter.onAttachView(this)
    }

    override fun onCleared() {
        presenter.onDetachView()
        super.onCleared()
    }

    fun onPhotoPicked(imageUri: InputStream?) = viewModelScope.launch(Dispatchers.IO) {
        imageUri?.let {
            uploadAvatarUseCase.uploadAvatar(it)
        }
    }

    override fun displayPicture(mapStringImageToBitmap: Bitmap) {
        mapStringImageToBitmap?.let {
            _livedataTransformedImage.postValue(it)
        }
    }

    override fun displayError(error: String) {
        _livedataError.postValue(error)
    }
}