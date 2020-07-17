package com.pinkmyhair.service.api

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Part

interface IPictureUploadWebService {

    @POST("/upload")
    suspend fun uploadAvatar(@Part file: MultipartBody.Part): Response<String>
}