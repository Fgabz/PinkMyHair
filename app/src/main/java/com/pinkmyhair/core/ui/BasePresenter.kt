package com.pinkmyhair.core.ui

interface BasePresenter<V : BaseView> {

    var view: V?

    fun onAttachView(view: V) {
        this.view = view
    }

    fun onDetachView() {
        this.view = null
    }
}