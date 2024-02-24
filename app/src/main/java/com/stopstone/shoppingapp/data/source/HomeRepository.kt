package com.stopstone.shoppingapp.data.source

import com.squareup.moshi.Moshi
import com.stopstone.shoppingapp.data.model.HomeResponse
import com.stopstone.shoppingapp.data.source.asset.AssetLoader
import com.stopstone.shoppingapp.data.source.remote.ShoppingService

class HomeRepository(private val shoppingService: ShoppingService) {

    suspend fun getBannerJsonData(): HomeResponse {
        return shoppingService.getHomeData()
    }
}