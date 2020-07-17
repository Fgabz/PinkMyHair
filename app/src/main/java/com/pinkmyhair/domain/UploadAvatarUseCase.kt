package com.pinkmyhair.domain

import com.pinkmyhair.entity.Answer
import java.io.InputStream

interface UploadAvatarUseCase {

    suspend fun uploadAvatar(avatar: InputStream, mediaType: String?): Answer<Any>
}