package com.ilkeryildirim.vitrinova.api.model.discover

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularProducts(
        var id: Int?,
        var title: String?,
        var defination: String?,
        var images: List<Image?>) : Parcelable