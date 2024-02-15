package com.stopstone.shoppingapp

import android.content.Context
import java.io.BufferedReader

class AssetLoader {
    fun loadAsset(context: Context, fileName: String): String {
        val assetManager = context.assets
        val inputStream = assetManager.open(fileName)
        val bufferedReader = BufferedReader(inputStream.reader())
        return bufferedReader.readText()
    }
}