package com.pinkmyhair.repository

import com.pinkmyhair.entity.Answer
import java.io.InputStream

interface AvatarDatasource {


    suspend fun uploadAvatar(avatarFile: InputStream, mediaType: String?): Answer<String>

}