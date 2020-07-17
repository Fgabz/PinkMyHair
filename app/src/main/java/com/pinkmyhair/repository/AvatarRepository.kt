package com.pinkmyhair.repository

import com.pinkmyhair.annotation.PerApp
import com.pinkmyhair.repository.service.IRemoteAvatarUploadService
import java.io.InputStream
import javax.inject.Inject

@PerApp
class AvatarRepository @Inject constructor(private val service: IRemoteAvatarUploadService) : AvatarDatasource {

    override suspend fun uploadAvatar(avatarFile: InputStream, mediaType: String?) = service.uploadAvatar(avatarFile, mediaType)
}