package com.ilkeryildirim.vitrinova.api.model.discover


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    @SerializedName("children")
    var children: List<Children>?,
    @SerializedName("cover")
    var cover: Cover?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("logo")
    var logo: Logo?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("order")
    var order: Int,
    @SerializedName("parent_category")
    var parentCategory: ParentCategory,
    @SerializedName("parent_id")
    var parentId: Int?
):Parcelable