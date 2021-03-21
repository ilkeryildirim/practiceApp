package com.ilkeryildirim.vitrinova.api.model.discover


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Logo(
    @SerializedName("height")
    var height: Int?,
    @SerializedName("medium")
    var medium: Medium?,
    @SerializedName("thumbnail")
    var thumbnail: Thumbnail?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("width")
    var width: Int?
):Parcelable