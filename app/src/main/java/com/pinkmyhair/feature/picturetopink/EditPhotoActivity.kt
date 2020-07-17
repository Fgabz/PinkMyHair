package com.pinkmyhair.feature.picturetopink

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.lifecycle.ViewModelProvider
import com.pinkmyhair.R
import com.pinkmyhair.annotation.IDaggerFactoryViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import javax.inject.Inject

class EditPhotoActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: IDaggerFactoryViewModel

    private lateinit var viewModel: EditPhotoViewController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory).get(EditPhotoViewController::class.java)

        pickerButton.setOnClickListener {
            openPhotoGalleryApplication(REQUEST_CODE_IMAGE_PICKER)
        }

        viewModel.onCreate()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            data?.data?.let {
                viewModel.onPhotoPicked(contentResolver.openInputStream(it), contentResolver.getType(it))
            }
        }
    }

    fun openPhotoGalleryApplication(requestCode: Int) {
        val pickPhoto = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(pickPhoto, requestCode, null)
    }

    companion object {
        const val REQUEST_CODE_IMAGE_PICKER = 8758
    }
}