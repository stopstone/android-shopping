package com.stopstone.shoppingapp.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeResponse(
    val banners: List<Banner>
)