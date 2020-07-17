package com.pinkmyhair.feature.picturetopink

import android.content.Context
import com.pinkmyhair.R
import com.pinkmyhair.core.ui.decodeBase64ToBitmap
import javax.inject.Inject

class EditPhotoViewStateMapper @Inject constructor(private val context: Context) : IEditPhotoViewStateMapper {
    override fun mapStringImageToBitmap(image: String) = image.decodeBase64ToBitmap()

    override fun mapToServerError() = context.getString(R.string.error_server)

    override fun mapToDecodingError() = context.getString(R.string.decoding_error)
}