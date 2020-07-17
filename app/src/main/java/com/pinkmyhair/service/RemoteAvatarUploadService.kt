package com.pinkmyhair.service

import com.pinkmyhair.entity.Answer
import com.pinkmyhair.repository.service.IRemoteAvatarUploadService
import com.pinkmyhair.service.api.IPictureUploadWebService
import com.pinkmyhair.service.extension.bytes
import com.pinkmyhair.service.extension.throwHttpException
import com.pinkmyhair.service.extension.throwIOException
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import timber.log.Timber
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class RemoteAvatarUploadService @Inject constructor(private val webService: IPictureUploadWebService) : IRemoteAvatarUploadService {

    override suspend fun uploadAvatar(avatar: InputStream, mediaType: String?): Answer<String> {
        lateinit var response: Response<String>

        val requestBody = avatar.bytes.toRequestBody(mediaType?.toMediaType())
        val filePart = MultipartBody.Part.createFormData(FILE_PARAM_NAME, FILENAME_PARAM, requestBody)

        try {
            avatar.close()
        } catch (e: IOException) {
            Timber.w(e)
        }

        try {
            response = webService.uploadAvatar(filePart)
        } catch (e: IOException) {
            return e.throwIOException()
        }

        response.body()?.let {
            return Answer.Success(it)
        } ?: run {
            return response.throwHttpException()
        }
    }

    companion object {
        const val FILE_PARAM_NAME = "file"
        const val FILENAME_PARAM = "avatar.jpg"
    }
}