package com.ilkeryildirim.vitrinova.ui.subviews.editorShops

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ilkeryildirim.vitrinova.R
import com.ilkeryildirim.vitrinova.api.model.discover.Shop
import com.ilkeryildirim.vitrinova.databinding.ItemEditorShopBinding


class EditorShopsAdapter(var editoShops:List<Shop>): RecyclerView.Adapter<EditorShopsAdapter.ViewHolder>() {
    private var lastPosition = -1
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding :ItemEditorShopBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_editor_shop, parent, false)
        context=parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(editoShops[position])
        setAnimation(holder.itemView,position)
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        holder.itemView.clearAnimation()
        super.onViewDetachedFromWindow(holder)
    }

    override fun getItemCount(): Int {
        return editoShops.size
    }

    class ViewHolder(private val binding: ItemEditorShopBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = EditorShopItemViewModel()
        fun bind(shop: Shop){
            binding.viewModel = viewModel
            viewModel.bind(shop)
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