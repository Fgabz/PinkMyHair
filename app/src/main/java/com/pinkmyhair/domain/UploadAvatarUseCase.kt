package com.pinkmyhair.domain

import java.io.InputStream

interface UploadAvatarUseCase {

    suspend fun uploadAvatar(imageStream: InputStream)
}