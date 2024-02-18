package com.stopstone.shoppingapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Banner(
    val id: String,
    @Json(name = "background_image_url") val backgroundImageUrl: String,
    val badge: Badge,
    @Json(name = "head_line") val headLine: String,
    @Json(name = "product_detail") val productDetail: ProductDetail
)

@JsonClass(generateAdapter = true)
data class Badge(
    val label: String, @Json(name = "background_color") val backgroundColor: String
)

@JsonClass(generateAdapter = true)
data class ProductDetail(
    val id: String,
    @Json(name = "brand_name") val brandName: String,
    @Json(name = "item_name") val itemName: String,
    @Json(name = "discount_rate") val discountRate: Int,
    val price: Int,
    @Json(name = "thumbnail_image_url") val thumbnailImageUrl: String,
)
