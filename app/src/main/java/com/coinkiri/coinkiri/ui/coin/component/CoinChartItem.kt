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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.coinkiri.coinkiri.R
import com.coinkiri.coinkiri.core.designsystem.theme.CoinkiriTheme
import com.coinkiri.coinkiri.core.designsystem.theme.Gray400
import com.coinkiri.coinkiri.core.util.CustomMarkerView
import com.coinkiri.coinkiri.core.util.Formatter.formatDateTime
import com.coinkiri.coinkiri.core.util.Formatter.formattedPrice
import com.coinkiri.coinkiri.ui.coin.coindetail.CoinDetailViewModel
import com.coinkiri.coinkiri.ui.coin.model.PriceModel
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

@Composable
fun CoinChartItem(
    viewModel: CoinDetailViewModel,
) {
    val selectedPriceInfo by viewModel.selectedPriceInfo.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .padding(vertical = 15.dp)
    ) {
        ChartInfo(selectedPriceInfo = selectedPriceInfo)
        ChartViewItem(
            viewModel = viewModel,
            onPriceSelected = { priceInfo ->
                viewModel.updateSelectedPriceInfo(priceInfo)
            }
        )
    }
}

@Composable
private fun ChartInfo(
    selectedPriceInfo: PriceModel
) {
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
                text = formatDateTime(selectedPriceInfo.candleDateTimeKst),
                fontWeight = FontWeight.SemiBold,
                style = CoinkiriTheme.typography.titleMedium,
                color = Gray400
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_coin_detail_marker),
                    contentDescription = "",
                    tint = Color.Green
                )
                Text(
                    text = "₩ ${formattedPrice(selectedPriceInfo.tradePrice)}",
                    fontWeight = FontWeight.SemiBold,
                    style = CoinkiriTheme.typography.titleMedium,
                )
            }
        }
    }
}

@Composable
private fun ChartViewItem(
    viewModel: CoinDetailViewModel,
    onPriceSelected: (PriceModel) -> Unit
) {
    val reversedCoinInfo by viewModel.reversedCoinInfo.collectAsStateWithLifecycle()
    val changeRateColor by viewModel.changeRateColor.collectAsStateWithLifecycle()
    val maxValue by viewModel.maxValue.collectAsStateWithLifecycle()
    val minValue by viewModel.minValue.collectAsStateWithLifecycle()

    if (reversedCoinInfo.isNotEmpty()) {
        onPriceSelected(reversedCoinInfo.last())
    }

    AndroidView(
        factory = { context ->
            val chart = LineChart(context)

            // chart 기본 세팅
            chart.description.isEnabled = false
            chart.legend.isEnabled = false
            chart.setPinchZoom(true)
            chart.setTouchEnabled(true)
            chart.marker = CustomMarkerView(context, R.layout.custom_marker_view)

            // chart 축 설정
            chart.xAxis.isEnabled = false
            chart.xAxis.setDrawGridLines(false)
            chart.axisLeft.isEnabled = false
            chart.axisLeft.setDrawGridLines(false)
            chart.axisRight.axisMaximum = maxValue
            chart.axisRight.axisMinimum = minValue
            chart.axisRight.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART)

            chart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
                override fun onValueSelected(e: Entry?, h: Highlight?) {
                    e?.let {
                        val index = it.x.toInt()
                        if (index in reversedCoinInfo.indices) {
                            onPriceSelected(reversedCoinInfo[index])
                        }
                    }
                }

                override fun onNothingSelected() {}
            })

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

            val startColor = changeRateColor.copy(alpha = 0.5f).toArgb()
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
            viewModel = hiltViewModel(),
        )
    }
}
