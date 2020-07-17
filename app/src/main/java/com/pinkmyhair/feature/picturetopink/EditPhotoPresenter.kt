package com.pinkmyhair.feature.picturetopink

import com.pinkmyhair.annotation.PerActivity
import javax.inject.Inject

@PerActivity
class EditPhotoPresenter @Inject constructor() : IEditPhotoPresenter {
    override var view: IEditPhotoView? = null
}