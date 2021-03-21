package com.ilkeryildirim.vitrinova.api.model.discover


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shop(
    @SerializedName("comment_count")
    var commentCount: Int?,
    @SerializedName("cover")
    var cover: Cover?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("definition")
    var definition: String?,
    @SerializedName("follower_count")
    var followerCount: Int?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("is_editor_choice")
    var isEditorChoice: Boolean?,
    @SerializedName("is_following")
    var isFollowing: Boolean?,
    @SerializedName("logo")
    var logo: Logo?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("name_updateable")
    var nameUpdateable: Boolean?,
    @SerializedName("product_count")
    var productCount: Int?,
    @SerializedName("share_url")
    var shareUrl: String?,
    @SerializedName("shop_payment_id")
    var shopPaymentId: Int?,
    @SerializedName("shop_rate")
    var shopRate: Int?,
    @SerializedName("slug")
    var slug: String?,
    @SerializedName("vacation_mode")
    var vacationMode: Int?,
    @SerializedName("popular_products")
    var popularProducts: List<PopularProducts>
):Parcelable