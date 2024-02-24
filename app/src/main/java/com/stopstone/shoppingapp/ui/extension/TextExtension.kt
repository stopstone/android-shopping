package com.stopstone.shoppingapp.ui.extension

import android.graphics.Paint
import android.widget.TextView
import com.stopstone.shoppingapp.R
import java.text.DecimalFormat


fun TextView.applyNumberFormat(price: Int?) {
    price ?: return
    val decimalFormat = DecimalFormat("#,###")
    text = context.getString(R.string.format_price_unit, decimalFormat.format(price))
}

fun TextView.applyNumberStrikeStyleFormat(price: Int) {
    applyNumberFormat(price)
    paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
}