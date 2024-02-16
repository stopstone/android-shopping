package com.stopstone.shoppingapp.data

import com.squareup.moshi.Moshi
import com.stopstone.shoppingapp.data.model.BannersJsonData

class HomeRepository(private val assetLoader: AssetLoader) {

    fun getBannerJsonData(): BannersJsonData? {
        val result = assetLoader.loadAsset("home.json")
        if (result.isNullOrEmpty()) return null

        val moshi = Moshi.Builder().build()
        return moshi.adapter(BannersJsonData::class.java).fromJson(result)
    }
}