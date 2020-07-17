package com.pinkmyhair.repository.service

import com.pinkmyhair.entity.Answer
import java.io.InputStream

interface IRemoteAvatarUploadService {
    suspend fun uploadAvatar(avatar: InputStream): Answer<String>
}