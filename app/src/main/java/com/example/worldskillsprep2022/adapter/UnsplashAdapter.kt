package com.example.worldskillsprep2022.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.worldskillsprep2022.R
import com.example.worldskillsprep2022.databinding.ItemRvBinding
import com.example.worldskillsprep2022.model.UnsplashResults

class UnsplashAdapter : ListAdapter<UnsplashResults.UnsplashPhoto, UnsplashAdapter.UnsplashViewHolder>(UserItemDiffCallBack()) {

    class UnsplashViewHolder(val binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindTo(photo: UnsplashResults.UnsplashPhoto){
            with(binding){
                tv.text = photo.description ?: "Description not found"
                Log.d("desc: ",  "${photo.description}")
                if (photo.urls.regular.isNotBlank()){
                    Glide.with(imgv.context)
                        .load(photo.urls.regular)
                        .circleCrop()
                        .into(imgv)
                }
                else{
                    imgv.setImageResource(R.drawable.ic_not_found)
                }
            }
        }
    }

    class UserItemDiffCallBack : DiffUtil.ItemCallback<UnsplashResults.UnsplashPhoto>(){
        override fun areItemsTheSame(
            oldItem: UnsplashResults.UnsplashPhoto,
            newItem: UnsplashResults.UnsplashPhoto
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: UnsplashResults.UnsplashPhoto,
            newItem: UnsplashResults.UnsplashPhoto
        ): Boolean = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnsplashViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvBinding.inflate(inflater, parent, false)

        return UnsplashViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UnsplashViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }
}