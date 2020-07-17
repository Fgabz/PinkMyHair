package com.pinkmyhair.service

import android.util.Base64
import com.pinkmyhair.entity.Answer
import com.pinkmyhair.repository.service.IRemoteAvatarUploadService
import com.pinkmyhair.service.api.IPictureUploadWebService
import com.pinkmyhair.service.entity.RemotePhoto
import com.pinkmyhair.service.entity.RemotePhotoAnswer
import com.pinkmyhair.service.extension.bytes
import com.pinkmyhair.service.extension.throwHttpException
import com.pinkmyhair.service.extension.throwIOException
import retrofit2.Response
import timber.log.Timber
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class RemoteAvatarUploadService @Inject constructor(private val webService: IPictureUploadWebService) : IRemoteAvatarUploadService {

    override suspend fun uploadAvatar(avatar: InputStream, mediaType: String?): Answer<String> {
        lateinit var response: Response<RemotePhotoAnswer>

        try {
            val encodedString = Base64.encodeToString(avatar.bytes, Base64.DEFAULT)

            try {
                avatar.close()
            } catch (e: IOException) {
                Timber.w(e)
            }

            response = webService.uploadAvatar(RemotePhoto(encodedString))
        } catch (e: IOException) {
            return e.throwIOException()
        }

        response.body()?.let {
            return Answer.Success(it.base64Image)
        } ?: run {
            return response.throwHttpException()
        }
    }

    companion object {
        const val FILE_PARAM_NAME = "b64_img"
        const val FILENAME_PARAM = "avatar.jpg"
    }
}