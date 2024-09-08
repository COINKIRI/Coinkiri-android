package com.coinkiri.coinkiri.core.util

import android.annotation.SuppressLint
import android.content.Context
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF

@SuppressLint("ViewConstructor")
class CustomMarkerView(
    context: Context,
    layoutResource: Int
) : MarkerView(context, layoutResource) {

    override fun refreshContent(e: Entry?, highlight: Highlight?) =
        super.refreshContent(e, highlight)

    override fun getOffset() =
        MPPointF(
            -(width / 2).toFloat(),
            -(height / 2).toFloat()
        )
}
