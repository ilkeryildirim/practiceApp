package com.ilkeryildirim.vitrinova.ui.subviews.featured

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.viewpager.widget.PagerAdapter
import com.ilkeryildirim.vitrinova.api.model.discover.Featured
import com.ilkeryildirim.vitrinova.databinding.ItemFeaturedSlideBinding

class FeaturedSliderViewPager (var context: Context, var featureds: List<Featured>) : PagerAdapter() {

    private var _binding: ItemFeaturedSlideBinding? = null
    private val binding get() = _binding!!
    val viewModel = FeaturedSliderItemViewModel()
    override fun isViewFromObject(@NonNull view: View, @NonNull `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return featureds.size
    }

    @NonNull
    override fun instantiateItem(@NonNull container: ViewGroup, position: Int): Any {
        _binding = ItemFeaturedSlideBinding.inflate(LayoutInflater.from(context), container, false)
        binding.viewModel = viewModel
        viewModel.bind(featureds[position])
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(@NonNull container: ViewGroup, position: Int, @NonNull `object`: Any) {
        container.removeView(`object` as View)
    }
}