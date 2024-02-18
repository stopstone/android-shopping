package com.stopstone.shoppingapp.ui.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.stopstone.shoppingapp.R

fun ImageView.load(url: String) {
    if (url.isNotBlank()) {
        Glide.with(this)
            .load(url)
            .placeholder(R.color.grey_09)
            .error(R.drawable.ic_image_not_supported)
            .into(this)
    } else {
        setImageResource(R.drawable.ic_image_not_supported)
    }
}