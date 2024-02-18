package com.stopstone.shoppingapp.data.source

import com.stopstone.shoppingapp.data.model.Product
import com.stopstone.shoppingapp.data.source.remote.ShoppingService

class ProductDetailRepository(private val shoppingService: ShoppingService) {
    suspend fun getProduct(id: String): Product {
        return shoppingService.getProduct(id)
    }
}