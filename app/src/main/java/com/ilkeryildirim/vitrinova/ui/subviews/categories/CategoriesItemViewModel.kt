package com.ilkeryildirim.vitrinova.ui.subviews.categories


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ilkeryildirim.vitrinova.api.model.discover.Category


class CategoriesItemViewModel : ViewModel() {


    private val imageUrl = MutableLiveData<String?>()
    private val title = MutableLiveData<String>()

    fun bind(category: Category) {
        this.imageUrl.value = category.logo?.thumbnail?.url
        this.title.value = category.name
    }

    fun getImageUrl() = imageUrl

    fun getTitle() = title


}
