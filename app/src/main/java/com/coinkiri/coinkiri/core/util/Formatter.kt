package com.coinkiri.coinkiri.core.util

import java.text.DecimalFormat

object Formatter {

    fun formattedTradePrice(tradePrice: Double?): String =
        tradePrice?.let { DecimalFormat("#,###").format(it) } ?: "0"

    fun formattedSignedChangeRate(signedChangeRate: Double?): String =
        String.format("%.2f", signedChangeRate?.times(100) ?: 0.0) + "%"
}
