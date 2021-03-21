package com.ilkeryildirim.vitrinova.api.model.discover


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    @SerializedName("cargo_time")
    var cargoTime: Int?,
    @SerializedName("category")
    var category: Category?,
    @SerializedName("category_id")
    var categoryId: Int?,
    @SerializedName("code")
    var code: Int?,
    @SerializedName("comment_count")
    var commentCount: Int?,
    @SerializedName("commission_rate")
    var commissionRate: Int?,
    @SerializedName("definition")
    var definition: String?,
    @SerializedName("difference")
    var difference: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("images")
    var images: List<Image>?,
    @SerializedName("is_active")
    var isActive: Boolean?,
    @SerializedName("is_approved")
    var isApproved: Boolean?,
    @SerializedName("is_cargo_free")
    var isCargoFree: Boolean?,
    @SerializedName("is_editor_choice")
    var isEditorChoice: Boolean?,
    @SerializedName("is_liked")
    var isLiked: Boolean?,
    @SerializedName("is_new")
    var isNew: Boolean?,
    @SerializedName("is_owner")
    var isOwner: Boolean?,
    @SerializedName("like_count")
    var likeCount: Int?,
    @SerializedName("max_installment")
    var maxInstallment: Int?,
    @SerializedName("old_price")
    var oldPrice: Int?,
    @SerializedName("price")
    var price: Int?,
    @SerializedName("reject_reason")
    var rejectReason: Int?,
    @SerializedName("share_url")
    var shareUrl: String?,
    @SerializedName("shop")
    var shop: Shop?,
    @SerializedName("slug")
    var slug: String?,
    @SerializedName("stock")
    var stock: Int?,
    @SerializedName("title")
    var title: String?
):Parcelable