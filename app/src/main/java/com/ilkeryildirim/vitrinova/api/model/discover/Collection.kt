package com.ilkeryildirim.vitrinova.api.model.discover


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Collection(
    @SerializedName("cover")
    var cover: Cover?,
    @SerializedName("definition")
    var definition: String?,
    @SerializedName("end")
    var end: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("logo")
    var logo: Logo?,
    @SerializedName("share_url")
    var shareUrl: String?,
    @SerializedName("start")
    var start: String?,
    @SerializedName("title")
    var title: String?
):Parcelable