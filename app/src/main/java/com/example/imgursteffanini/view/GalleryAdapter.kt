package com.example.imgursteffanini.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.imgursteffanini.databinding.ItemGalleryBinding
import com.example.imgursteffanini.model.Data
import com.example.imgursteffanini.util.createCoverJpgUrl
import com.example.imgursteffanini.util.loadUrlWithCrop

class GalleryAdapter() : ListAdapter<Data, GalleryViewHolder>(
    DIFF_CALLBACK
) {

    private var cats: List<Data> = ArrayList()

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(
                oldItem: Data,
                newItem: Data
            ): Boolean {
                return oldItem == newItem
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: Data,
                newItem: Data
            ): Boolean {
                return oldItem.cover.equals(newItem.cover)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder.create(
            parent
        )
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

class GalleryViewHolder(
    private val itemBinding: ItemGalleryBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    @SuppressLint("ResourceAsColor")
    fun bind(cat: Data) {

        itemBinding.run {
            ivCat.loadUrlWithCrop(cat.cover?.let { cat.createCoverJpgUrl(it) })
        }
    }

    companion object {
        fun create(parent: ViewGroup): GalleryViewHolder {
            val itemBinding = ItemGalleryBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return GalleryViewHolder(
                itemBinding,
            )
        }
    }
}