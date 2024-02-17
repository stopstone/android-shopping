package com.stopstone.shoppingapp.data

import com.squareup.moshi.Moshi
import com.stopstone.shoppingapp.data.model.Product
import com.stopstone.shoppingapp.data.model.ProductDetailResponse

class ProductDetailRepository(private val assetLoader: AssetLoader) {
    fun getProduct(id: String): Product? {
        val result = assetLoader.loadAsset("products.json")
        if (result.isNullOrEmpty()) return null

        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(ProductDetailResponse::class.java)
        return jsonAdapter.fromJson(result)?.products?.get(id)
    }
}