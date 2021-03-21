package com.ilkeryildirim.vitrinova.ui.subviews.collections


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilkeryildirim.vitrinova.api.model.discover.Collection


class CollectionsItemViewModel : ViewModel() {


    private val imageUrl = MutableLiveData<String?>()
    private val title = MutableLiveData<String>()
    private val subtitle = MutableLiveData<String>()

    fun bind(collection: Collection) {
        this.imageUrl.value = collection.logo?.medium?.url
        this.title.value = collection.title
        this.subtitle.value = collection.definition
    }

    fun getImageUrl() = imageUrl

    fun getTitle() = title

    fun getSubtitle() = subtitle


}
