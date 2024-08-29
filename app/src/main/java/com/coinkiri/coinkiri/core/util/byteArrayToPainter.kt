package com.coinkiri.coinkiri.core.util

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import java.util.Base64

fun byteArrayToPainter(string: String?): BitmapPainter {
    val byteArraySymbolImage = Base64.getDecoder().decode(string)
    val bitmap = BitmapFactory.decodeByteArray(byteArraySymbolImage, 0, byteArraySymbolImage.size)
    return BitmapPainter(bitmap.asImageBitmap())
}
