package com.stopstone.shoppingapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeResponse(
    val banners: List<Banner>,
    val promotions: Promotion,
    val recommendations: Recommendation
)

@JsonClass(generateAdapter = true)
data class Promotion(
    val title: String,
    val items: List<ProductDetail>
)

@JsonClass(generateAdapter = true)
data class Recommendation(
    val title: String,
    val categories: List<Category>,
)

@JsonClass(generateAdapter = true)
data class Category(
    val id: String,
    val label: String,
    @Json(name = "image_url") val imageUrl: String,
    val items: List<ProductDetail>
)