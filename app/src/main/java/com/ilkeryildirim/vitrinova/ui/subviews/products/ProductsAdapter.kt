package com.ilkeryildirim.vitrinova.ui.subviews.products

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ilkeryildirim.vitrinova.R
import com.ilkeryildirim.vitrinova.api.model.discover.Product
import com.ilkeryildirim.vitrinova.databinding.ItemProductBinding


class ProductsAdapter(var products:List<Product>): RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    private var lastPosition = -1
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding :ItemProductBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_product, parent, false)
        context=parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
        setAnimation(holder.itemView,position)
    }


    override fun onViewDetachedFromWindow(holder: ProductsAdapter.ViewHolder) {
        holder.itemView.clearAnimation()
        super.onViewDetachedFromWindow(holder)
    }


    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(private val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel = ProductsItemViewModel()
        fun bind(product: Product){
            binding.viewModel = viewModel
            binding.tvOldPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            viewModel.bind(product)

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