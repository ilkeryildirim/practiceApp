package com.ilkeryildirim.vitrinova.ui.products

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilkeryildirim.vitrinova.api.model.discover.DiscoverModel
import com.ilkeryildirim.vitrinova.ui.subviews.featured.FeaturedSliderViewPager
import com.ilkeryildirim.vitrinova.ui.subviews.products.ProductsAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
) : ViewModel() {


    var onNavigateToItemDetail = MutableLiveData<Nothing>()
    var featuredViewPagerAdapter: FeaturedSliderViewPager? = null
    var productsAdapter: ProductsAdapter? = null

    private val _uiState = MutableStateFlow<ProductsFragmentUIState>(ProductsFragmentUIState.Initial)
    val uiState: StateFlow<ProductsFragmentUIState> = _uiState
    private lateinit var discoverData: List<DiscoverModel>

}


sealed class ProductsFragmentUIState {
    object Initial : ProductsFragmentUIState()
    object Loading : ProductsFragmentUIState()
    data class Navigating(var destinationId:Int,var bundle: Bundle) : ProductsFragmentUIState()
    data class Error(val message: String) : ProductsFragmentUIState()
}