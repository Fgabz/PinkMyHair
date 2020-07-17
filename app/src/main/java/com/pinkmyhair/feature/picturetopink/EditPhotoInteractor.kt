package com.pinkmyhair.feature.picturetopink

import com.pinkmyhair.annotation.PerActivity
import com.pinkmyhair.domain.UploadAvatarUseCase
import com.pinkmyhair.entity.Answer
import com.pinkmyhair.repository.AvatarDatasource
import timber.log.Timber
import java.io.InputStream
import javax.inject.Inject

@PerActivity
class EditPhotoInteractor @Inject constructor(private val repository: AvatarDatasource) : UploadAvatarUseCase {

    override suspend fun uploadAvatar(inputStream: InputStream, mediaType: String?): Answer<Any> {

        val result =  repository.uploadAvatar(inputStream, mediaType)

        Timber.d("RESULT $result")

        return result
    }
}