package com.stopstone.shoppingapp.ui.extension

import android.widget.TextView
import com.stopstone.shoppingapp.R
import java.text.DecimalFormat


fun TextView.applyNumberFormat(price: Int) {
    val decimalFormat = DecimalFormat("#,###")
    text = context.getString(R.string.format_price_unit, decimalFormat.format(price))
}