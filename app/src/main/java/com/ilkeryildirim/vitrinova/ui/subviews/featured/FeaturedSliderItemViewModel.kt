package com.ilkeryildirim.vitrinova.ui.subviews.featured

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilkeryildirim.vitrinova.api.model.discover.Featured


class FeaturedSliderItemViewModel : ViewModel() {

    private val imageUrl = MutableLiveData<String?>()
    private val id = MutableLiveData<Int?>()
    private val title = MutableLiveData<String>()
    private val subTitle = MutableLiveData<String>()


    fun bind(featured: Featured) {
        this.id.value = featured.id
        this.imageUrl.value = featured.cover?.url
        this.title.value = featured.title
        this.subTitle.value = featured.subTitle

    }

    fun getImageUrl() = imageUrl

    fun getTitle() = title

    fun getSubTitle() = subTitle

}