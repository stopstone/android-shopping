package com.stopstone.shoppingapp.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductDetailResponse(
    val products: Map<String, Product>
)