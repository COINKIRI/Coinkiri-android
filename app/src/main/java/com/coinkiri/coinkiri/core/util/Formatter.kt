package com.coinkiri.coinkiri.core.util

import java.text.DecimalFormat
import java.time.format.DateTimeFormatter
import java.util.Locale

object Formatter {

    private const val PRICE_FORMAT = "#,###"
    private const val DEFAULT_PRICE = "0"

    private const val SIGNED_CHANGE_RATE_FORMAT = "%.2f"
    private const val PERCENT_SYMBOL = "%"

    private const val KRW_PREFIX = "KRW-"
    private const val EMPTY_STRING = ""

    private const val DATE_INPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    private const val DATE_OUTPUT_FORMAT = "yyyy년 MM월 dd일, HH시 mm분"

    fun formattedPrice(price: Double?): String =
        price?.let { DecimalFormat(PRICE_FORMAT).format(it) } ?: DEFAULT_PRICE

    fun formattedSignedChangeRate(signedChangeRate: Double?): String =
        String.format(
            Locale.KOREAN,
            SIGNED_CHANGE_RATE_FORMAT,
            signedChangeRate?.times(100) ?: 0.0
        ) + PERCENT_SYMBOL

    fun removeKrWPrefix(input: String?): String =
        input?.replace(KRW_PREFIX, EMPTY_STRING) ?: EMPTY_STRING

    fun formatDateTime(input: String?): String {
        return input?.let {
            try {
                val formatter = DateTimeFormatter.ofPattern(DATE_INPUT_FORMAT)
                val dateTime = java.time.LocalDateTime.parse(it, formatter)
                val outputFormatter = DateTimeFormatter.ofPattern(DATE_OUTPUT_FORMAT)
                dateTime.format(outputFormatter)
            } catch (e: Exception) {
                EMPTY_STRING
            }
        } ?: EMPTY_STRING
    }
}
