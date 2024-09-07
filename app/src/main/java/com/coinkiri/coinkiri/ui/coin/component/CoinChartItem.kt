package com.coinkiri.coinkiri.ui.coin.component

import android.graphics.drawable.GradientDrawable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.Black
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray400
import com.coinkiri.coinkiri.ui.coin.model.CoinDetailModel
import com.coinkiri.coinkiri.ui.coin.model.PriceModel
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

@Composable
fun CoinChartItem(
    coinDetailInfo: CoinDetailModel,
    changeRateColor: Color
) {
    val reversedCoinInfo = coinDetailInfo.price.reversed()

    Column(
        modifier = Modifier
            .padding(vertical = 15.dp)
    ) {
        ChartInfo()
        ChartViewItem(
            reversedCoinInfo = reversedCoinInfo,
            changeRateColor = changeRateColor
        )
    }
}

@Composable
private fun ChartInfo() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 5.dp,
                horizontal = 10.dp
            )
    ) {
        Text(
            text = "시세차트",
            style = CoinkiriTheme.typography.titleLarge
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            modifier = Modifier.padding(start = 3.dp)
        ) {
            Text(
                text = "0000년 00월 00일, 09시 00분",
                fontWeight = FontWeight.SemiBold,
                style = CoinkiriTheme.typography.titleMedium,
                color = Gray400
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_circle_up),
                    contentDescription = "",
                    tint = Color.Green,
                )
                Text(
                    text = "₩ 100,000,000",
                    fontWeight = FontWeight.SemiBold,
                    style = CoinkiriTheme.typography.titleMedium,
                )
            }
        }
    }
}

@Composable
private fun ChartViewItem(
    reversedCoinInfo: List<PriceModel>,
    changeRateColor: Color
) {
    val maxValue = reversedCoinInfo.maxOfOrNull { it.tradePrice.toFloat() } ?: 0f
    val minValue = reversedCoinInfo.minOfOrNull { it.tradePrice.toFloat() } ?: 0f

    AndroidView(
        factory = { context ->
            val chart = LineChart(context)

            // chart 기본 세팅
            chart.description.isEnabled = false
            chart.legend.isEnabled = false
            chart.setPinchZoom(true)
            chart.setTouchEnabled(true)

            // chart 축 설정
            chart.xAxis.isEnabled = false
            chart.xAxis.setDrawGridLines(false)
            chart.axisLeft.isEnabled = false
            chart.axisLeft.setDrawGridLines(false)
            chart.axisRight.axisMaximum = maxValue
            chart.axisRight.axisMinimum = minValue
            chart.axisRight.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)

            chart
        },
        update = { chart ->
            val entries = reversedCoinInfo
                .mapIndexed { index, reversedCoinInfo ->
                    Entry(
                        index.toFloat(),
                        reversedCoinInfo.tradePrice.toFloat()
                    )
                }

            val startColor = changeRateColor.copy(alpha = 0.3f).toArgb()
            val endColor = changeRateColor.copy(alpha = 0f).toArgb()

            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(startColor, endColor)
            )

            val dataSet = LineDataSet(entries, "coinDetail")
                .apply {
                    fillDrawable = gradientDrawable
                    mode = LineDataSet.Mode.LINEAR
                    color = changeRateColor.toArgb()
                    lineWidth = 1f
                    setDrawCircles(false)
                    setDrawValues(false)
                    setDrawFilled(true)
                }

            chart.data = LineData(dataSet)
            chart.invalidate()
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
private fun CoinChartItemPreview() {
    CoinkiriTheme {
        CoinChartItem(
            coinDetailInfo = CoinDetailModel(),
            changeRateColor = Black
        )
    }
}
