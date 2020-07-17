package com.pinkmyhair.feature.picturetopink

import com.pinkmyhair.annotation.PerActivity
import javax.inject.Inject

@PerActivity
class EditPhotoPresenter @Inject constructor(private val mapper: IEditPhotoViewStateMapper) : IEditPhotoPresenter {
    override var view: IEditPhotoView? = null

    override fun displayError() {
        view?.displayError(mapper.mapToServerError())
    }

    override fun displayPicture(result: String) {
        mapper.mapStringImageToBitmap(result)?.let { view?.displayPicture(it) } ?: run {
            view?.displayError(mapper.mapToDecodingError())
        }
    }
}