package com.cleangithubviewer.core.ui

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setDivider(drawable: Int, orientation: Int = DividerItemDecoration.VERTICAL) {
    val divider = DividerItemDecoration(context, orientation)
    AppCompatResources.getDrawable(context, drawable)?.let {
        divider.setDrawable(it)
    }
    addItemDecoration(divider)
}