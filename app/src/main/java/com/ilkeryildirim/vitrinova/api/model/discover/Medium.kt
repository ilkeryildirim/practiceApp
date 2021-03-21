package com.ilkeryildirim.vitrinova.api.model.discover


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Medium(
    @SerializedName("height")
    var height: Int?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("width")
    var width: Int?
):Parcelable