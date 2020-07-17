package com.pinkmyhair.feature.picturetopink

import android.graphics.Bitmap
import com.pinkmyhair.core.ui.BaseView

interface IEditPhotoView : BaseView {
    fun displayPicture(mapStringImageToBitmap: Bitmap)
    fun displayError(error: String)
}