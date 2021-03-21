package com.ilkeryildirim.vitrinova.ui.discover

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ilkeryildirim.vitrinova.R
import com.ilkeryildirim.vitrinova.api.VitrinovaApiResult
import com.ilkeryildirim.vitrinova.api.model.discover.DiscoverModel
import com.ilkeryildirim.vitrinova.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DiscoverViewModel @Inject constructor(
        private val discoverDataRepository: DiscoverDataRepository
) : ViewModel() {


    private val _uiState = MutableStateFlow<DiscoverFragmentUIState>(DiscoverFragmentUIState.Initial)
    val uiState: StateFlow<DiscoverFragmentUIState> = _uiState
    private lateinit var discoverData: ArrayList<DiscoverModel>
    var isLoading=MutableLiveData<Boolean>()


    val onNavigateAllProductsPage=View.OnClickListener {
        _uiState.value = DiscoverFragmentUIState.Navigating(R.id.action_discoverFragment_to_productsFragment, bundleOf(Constants.PRODUCTS_KEY to discoverData))
        _uiState.value= DiscoverFragmentUIState.Initial
    }

    fun onRefresh() {
        _uiState.value=DiscoverFragmentUIState.Loading
        isLoading.value=true
    }

    fun getDiscoverData() {
        isLoading.value=true
        _uiState.value = DiscoverFragmentUIState.Loading
        viewModelScope.launch {
            discoverDataRepository.getDiscoverData().let { result ->
                when (result) {
                    is VitrinovaApiResult.Success -> {
                        discoverData = result.data
                        isLoading.value=false
                        _uiState.value = DiscoverFragmentUIState.Success(result.data)
                    }
                    is VitrinovaApiResult.Error -> {
                        result.message?.let {
                            _uiState.value = DiscoverFragmentUIState.Error(result.message)
                        }
                    }
                }
            }
        }
    }
}


sealed class DiscoverFragmentUIState {
    object Initial : DiscoverFragmentUIState()
    object Loading : DiscoverFragmentUIState()
    data class Navigating(var destinationId: Int, var bundle: Bundle) : DiscoverFragmentUIState()
    data class Success(var discoverData: ArrayList<DiscoverModel>) : DiscoverFragmentUIState()
    data class Error(val message: String) : DiscoverFragmentUIState()
}