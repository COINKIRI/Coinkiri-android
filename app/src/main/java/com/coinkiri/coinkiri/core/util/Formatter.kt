package com.coinkiri.coinkiri.core.util

import java.text.DecimalFormat
import java.util.Locale

object Formatter {

    fun formattedPrice(price: Double?): String =
        price?.let { DecimalFormat("#,###").format(it) } ?: "0"

    fun formattedSignedChangeRate(signedChangeRate: Double?): String =
        String.format(Locale.KOREAN, "%.2f", signedChangeRate?.times(100) ?: 0.0) + "%"

    fun removeKrWPrefix(input: String?): String =
        input?.replace("KRW-", "") ?: ""
}
