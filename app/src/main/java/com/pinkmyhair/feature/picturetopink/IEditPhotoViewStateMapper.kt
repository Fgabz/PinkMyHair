package com.pinkmyhair.feature.picturetopink

import android.graphics.Bitmap

interface IEditPhotoViewStateMapper {
    fun mapStringImageToBitmap(image: String): Bitmap?
    fun mapToServerError(): String
    fun mapToDecodingError(): String
}