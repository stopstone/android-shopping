package com.stopstone.shoppingapp.data.source

import com.squareup.moshi.Moshi
import com.stopstone.shoppingapp.data.model.HomeResponse
import com.stopstone.shoppingapp.data.source.asset.AssetLoader

class HomeRepository(private val assetLoader: AssetLoader) {

    fun getBannerJsonData(): HomeResponse? {
        val result = assetLoader.loadAsset("home.json")
        if (result.isNullOrEmpty()) return null

        val moshi = Moshi.Builder().build()
        return moshi.adapter(HomeResponse::class.java).fromJson(result)
    }
}