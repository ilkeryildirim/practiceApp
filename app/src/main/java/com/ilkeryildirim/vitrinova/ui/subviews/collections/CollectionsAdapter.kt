package com.ilkeryildirim.vitrinova.ui.subviews.collections

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ilkeryildirim.vitrinova.R
import com.ilkeryildirim.vitrinova.api.model.discover.Collection
import com.ilkeryildirim.vitrinova.databinding.ItemCategoriesBinding
import com.ilkeryildirim.vitrinova.databinding.ItemCollectionsBinding


class CollectionsAdapter(var collections:List<Collection>): RecyclerView.Adapter<CollectionsAdapter.ViewHolder>() {
    private var lastPosition = -1
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding :ItemCollectionsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_collections, parent, false)
        context=parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collections[position])
        setAnimation(holder.itemView,position)
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        holder.itemView.clearAnimation()
        super.onViewDetachedFromWindow(holder)
    }

    override fun getItemCount(): Int {
        return collections.size
    }

    class ViewHolder(private val binding: ItemCollectionsBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = CollectionsItemViewModel()
        fun bind(collection: Collection){
            binding.viewModel = viewModel
            viewModel.bind(collection)

        }
    }
    private fun setAnimation(viewToAnimate: View, position:Int) {
        if (position > lastPosition)
        {
            val animation = AnimationUtils.loadAnimation(context, R.anim.slide_right_to_left)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

}