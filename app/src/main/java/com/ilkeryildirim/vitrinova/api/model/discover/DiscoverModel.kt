package com.ilkeryildirim.vitrinova.api.model.discover


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DiscoverModel(
    @SerializedName("categories")
    var categories: List<Category>?,
    @SerializedName("collections")
    var collections: List<Collection>?,
    @SerializedName("featured")
    var featured: List<Featured>?,
    @SerializedName("products")
    var products: List<Product>?,
    @SerializedName("shops")
    var shops: List<Shop>?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("type")
    var type: String?

):Parcelable