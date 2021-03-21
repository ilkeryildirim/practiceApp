package com.ilkeryildirim.vitrinova.ui.subviews.categories

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ilkeryildirim.vitrinova.R
import com.ilkeryildirim.vitrinova.api.model.discover.Category
import com.ilkeryildirim.vitrinova.databinding.ItemCategoriesBinding


class CategoriesAdapter(var categories:List<Category>): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    private var lastPosition = -1
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding :ItemCategoriesBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_categories, parent, false)
        context=parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
        setAnimation(holder.itemView,position)
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        holder.itemView.clearAnimation()
        super.onViewDetachedFromWindow(holder)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class ViewHolder(private val binding: ItemCategoriesBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = CategoriesItemViewModel()
        fun bind(category: Category){
            binding.viewModel = viewModel
            viewModel.bind(category)

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