package com.ilkeryildirim.vitrinova.ui.subviews.editorShops


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilkeryildirim.vitrinova.api.model.discover.Shop


class EditorShopItemViewModel : ViewModel() {


    private val shopImageUrl = MutableLiveData<String?>()
    private val firstItemImageUrl = MutableLiveData<String?>()
    private val secondItemImageUrl = MutableLiveData<String?>()
    private val thirdItemImageUrl = MutableLiveData<String?>()
    private val title = MutableLiveData<String>()
    private val subtitle = MutableLiveData<String>()

    fun bind(shop: Shop) {
        shopImageUrl.value = shop.cover?.thumbnail?.url
    }

    fun getShopImageUrl() = shopImageUrl

    fun getFirstItemImageUrl() = firstItemImageUrl

    fun getSecondItemImageUrl() = secondItemImageUrl

    fun getThirdItemImageUrl() = thirdItemImageUrl

    fun getTitle() = title

    fun getSubtitle() = subtitle


}
