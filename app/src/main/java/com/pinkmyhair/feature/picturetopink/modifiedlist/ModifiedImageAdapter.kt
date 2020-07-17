package com.pinkmyhair.feature.picturetopink.modifiedlist

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.pinkmyhair.R

class ModifiedImageAdapter : RecyclerView.Adapter<ModifiedImageAdapter.ViewHolder>() {

    private val repositoryItems: MutableList<Bitmap> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.modified_image_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = repositoryItems[position]
        holder.bindTo(item, position)
    }

    fun add(item: Bitmap) {
        repositoryItems.add(item)
        notifyItemInserted(itemCount)
    }

    override fun getItemCount(): Int = repositoryItems.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.miniBitmapContainer)
        val description = itemView.findViewById<TextView>(R.id.imagePosition)

        fun bindTo(item: Bitmap, position: Int) {
            image.load(item)
            description.text = position.toString()
        }
    }
}