package com.stopstone.shoppingapp

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BannersJsonData(
    val banners: List<Banner>
)