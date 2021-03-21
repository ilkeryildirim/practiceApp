package com.ilkeryildirim.vitrinova.ui.subviews.products


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilkeryildirim.vitrinova.api.model.discover.Product


class ProductsItemViewModel : ViewModel() {


    private val imageUrl = MutableLiveData<String?>()
    private val id = MutableLiveData<Int?>()
    private val title = MutableLiveData<String>()
    private val sectionTitle = MutableLiveData<String>()
    private val shopName = MutableLiveData<String>()
    private val oldPrice = MutableLiveData<String>()
    private val price = MutableLiveData<String>()


    fun bind(product: Product) {
        this.id.value = product.id
        this.imageUrl.value = product.images?.get(0)?.thumbnail?.url
        this.title.value = product.title
        this.shopName.value = product.shop?.name
        this.price.value ="${product.price.toString()} TL"
        product.oldPrice?.let {
            this.oldPrice.value= "${product.oldPrice.toString()} TL"
        }
    }

    fun getImageUrl() = imageUrl

    fun getTitle() = title

    fun getShopName() = shopName

    fun getOldPrice() = oldPrice

    fun getPrice() = price


}
