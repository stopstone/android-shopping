package com.stopstone.shoppingapp.data.source.asset

import android.content.res.AssetManager
import java.io.BufferedReader
import java.io.IOException

class AssetLoader(private val assetManager: AssetManager) {
    fun loadAsset(fileName: String): String? {
        return kotlin.runCatching {
            try {
                val inputStream = assetManager.open(fileName)
                BufferedReader(inputStream.reader()).use {
                    it.readText()
                }
            } catch (e: IOException) {
                null
            }
        }.getOrNull()
    }
}