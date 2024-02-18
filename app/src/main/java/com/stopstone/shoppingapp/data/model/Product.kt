package com.stopstone.shoppingapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "brand_name") val brandName: String,
    @Json(name = "item_name") val itemName: String,
    @Json(name = "discount_rate") val discountRate: Int,
    @Json(name = "discount_price") val discountPrice: Int,
    val price: Int,
    val rating: Float,
    @Json(name = "representation_image_url") val representationImageUrl: String,
    @Json(name = "detail_images") val detailImages: List<String>
)