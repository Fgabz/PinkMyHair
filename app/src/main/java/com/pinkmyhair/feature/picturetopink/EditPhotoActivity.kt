package com.pinkmyhair.feature.picturetopink

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.pinkmyhair.R
import com.pinkmyhair.annotation.IDaggerFactoryViewModel
import com.pinkmyhair.core.ui.DefaultDividerItem
import com.pinkmyhair.feature.picturetopink.modifiedlist.ModifiedImageAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class EditPhotoActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: IDaggerFactoryViewModel

    private lateinit var viewModel: EditPhotoViewController

    private lateinit var adapter: ModifiedImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory).get(EditPhotoViewController::class.java)

        pickerButton.setOnClickListener {
            openPhotoGalleryApplication(REQUEST_CODE_IMAGE_PICKER)
        }

        setUpObserver()
        setupModifiedImageList()

        viewModel.onCreate()
    }

    private fun setupModifiedImageList() {
        adapter = ModifiedImageAdapter()

        modifiedImageList.adapter = adapter
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        modifiedImageList.layoutManager = linearLayoutManager
        modifiedImageList.addItemDecoration(
            DefaultDividerItem(
                resources.getDimensionPixelSize(R.dimen.item_list_margin_horizontale),
                resources.getDimensionPixelSize(R.dimen.item_list_margin_verticale)
            )
        )
    }

    private fun setUpObserver() {
        viewModel.livedataError.observe(this, Observer { message ->
            progress.visibility = View.GONE
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })

        viewModel.livedataTransformedImage.observe(this, Observer { bitmap ->
            progress.visibility = View.GONE
            imageContainer.load(bitmap)
            adapter.add(bitmap)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            data?.data?.let {
                viewModel.onPhotoPicked(contentResolver.openInputStream(it), contentResolver.getType(it))
                progress.visibility = View.VISIBLE
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