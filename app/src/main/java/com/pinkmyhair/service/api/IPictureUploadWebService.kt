package com.pinkmyhair.service.api

import com.pinkmyhair.service.entity.RemotePhoto
import com.pinkmyhair.service.entity.RemotePhotoAnswer
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IPictureUploadWebService {

    @POST("/upload")
    suspend fun uploadAvatar(@Body remotePhoto: RemotePhoto): Response<RemotePhotoAnswer>
}