package com.pinkmyhair.feature

import com.pinkmyhair.annotation.PerActivity

@PerActivity
class EditPhotoPresenter : IEditPhotoPresenter {
    override var view: IEditPhotoView
}