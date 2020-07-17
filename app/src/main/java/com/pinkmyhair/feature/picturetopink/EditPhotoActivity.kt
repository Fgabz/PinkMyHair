package com.pinkmyhair.feature.picturetopink

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pinkmyhair.R
import com.pinkmyhair.annotation.IDaggerFactoryViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class EditPhotoActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: IDaggerFactoryViewModel

    private lateinit var viewModel: EditPhotoViewController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory).get(EditPhotoViewController::class.java)



        viewModel.onCreate()
    }
}