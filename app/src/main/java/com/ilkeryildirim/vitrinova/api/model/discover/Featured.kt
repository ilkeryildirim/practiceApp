package com.ilkeryildirim.vitrinova.api.model.discover


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Featured(
    @SerializedName("cover")
    var cover: Cover?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("sub_title")
    var subTitle: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("type")
    var type: String?
):Parcelable