package com.coinkiri.coinkiri.ui.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.coinkiri.coinkiri.R

private val PretendardFont = FontFamily(
    Font(R.font.pretendard_bold, weight = FontWeight.Bold),
    Font(R.font.pretendard_semibold, weight = FontWeight.SemiBold),
    Font(R.font.pretendard_medium, weight = FontWeight.Medium),
    Font(R.font.pretendard_regular, weight = FontWeight.Normal)
)

private val YangJinFont = FontFamily(Font(R.font.yangjin_regular, weight = FontWeight.Normal))

@Immutable
data class CoinkiriTypography(
    val yangJinHeadlineSmall: TextStyle,
    val displayLarge: TextStyle,
    val displayMedium: TextStyle,
    val displaySmall: TextStyle,
    val headlineLarge: TextStyle,
    val headlineMedium: TextStyle,
    val headlineSmall: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val titleSmall: TextStyle,
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,
)

val LocalCoinkiriTypography = staticCompositionLocalOf {
    CoinkiriTypography(
        yangJinHeadlineSmall = TextStyle.Default,
        displayLarge = TextStyle.Default,
        displayMedium = TextStyle.Default,
        displaySmall = TextStyle.Default,
        headlineLarge = TextStyle.Default,
        headlineMedium = TextStyle.Default,
        headlineSmall = TextStyle.Default,
        titleLarge = TextStyle.Default,
        titleMedium = TextStyle.Default,
        titleSmall = TextStyle.Default,
        bodyLarge = TextStyle.Default,
        bodyMedium = TextStyle.Default,
        bodySmall = TextStyle.Default,
        labelLarge = TextStyle.Default,
        labelMedium = TextStyle.Default,
        labelSmall = TextStyle.Default,
    )
}

private val defaultLineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

private fun coinkiriTextStyle(
    fontFamily: FontFamily,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    lineHeight: TextUnit,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontWeight = fontWeight,
    fontSize = fontSize,
    lineHeight = lineHeight,
    lineHeightStyle = defaultLineHeightStyle
)

internal val Typography = CoinkiriTypography(
    yangJinHeadlineSmall = coinkiriTextStyle(fontFamily = YangJinFont, fontWeight = FontWeight.Normal, fontSize = 24.sp, lineHeight = 32.sp),

    displayLarge = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Bold, fontSize = 57.sp, lineHeight = 64.sp),
    displayMedium = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Bold, fontSize = 45.sp, lineHeight = 52.sp),
    displaySmall = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Bold, fontSize = 36.sp, lineHeight = 44.sp),

    headlineLarge = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.SemiBold, fontSize = 32.sp, lineHeight = 40.sp),
    headlineMedium = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.SemiBold, fontSize = 28.sp, lineHeight = 36.sp),
    headlineSmall = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, lineHeight = 32.sp),

    titleLarge = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Medium, fontSize = 22.sp, lineHeight = 28.sp),
    titleMedium = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Medium, fontSize = 16.sp, lineHeight = 24.sp),
    titleSmall = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp),

    bodyLarge = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 20.sp),
    bodySmall = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.sp),

    labelLarge = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp),
    labelMedium = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp),
    labelSmall = coinkiriTextStyle(fontFamily = PretendardFont, fontWeight = FontWeight.Medium, fontSize = 11.sp, lineHeight = 16.sp)
)
