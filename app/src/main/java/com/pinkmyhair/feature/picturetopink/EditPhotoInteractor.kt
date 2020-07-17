package com.pinkmyhair.feature.picturetopink

import com.pinkmyhair.annotation.PerActivity
import com.pinkmyhair.domain.UploadAvatarUseCase
import com.pinkmyhair.entity.Answer
import com.pinkmyhair.repository.AvatarDatasource
import java.io.InputStream
import javax.inject.Inject

@PerActivity
class EditPhotoInteractor @Inject constructor(
    private val repository: AvatarDatasource,
    private val presenter: IEditPhotoPresenter
) : UploadAvatarUseCase {

    override suspend fun uploadAvatar(imageStream: InputStream) {
        when (val result = repository.uploadAvatar(imageStream)) {
            is Answer.Success -> presenter.displayPicture(result.value)
            is Answer.Failure -> presenter.displayError()
        }
    }
}