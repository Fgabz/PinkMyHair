package com.pinkmyhair.feature.picturetopink

import com.pinkmyhair.core.ui.BasePresenter

interface IEditPhotoPresenter : BasePresenter<IEditPhotoView> {
    fun displayError()
    fun displayPicture(result: String)
}