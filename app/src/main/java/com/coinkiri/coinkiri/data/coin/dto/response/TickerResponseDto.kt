package com.coinkiri.coinkiri.data.coin.dto.response

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * 티커에 대한 응답을 나타내는 데이터 전송 객체(DTO).
 *
 * @property type 티커의 유형 (예: "ticker").
 * @property code 암호화폐 쌍의 코드 (예: "KRW-BTC").
 * @property openingPrice 암호화폐의 시가.
 * @property highPrice 암호화폐의 고가.
 * @property lowPrice 암호화폐의 저가.
 * @property tradePrice 암호화폐의 현재가.
 * @property prevClosingPrice 전일 종가.
 * @property accTradePrice 누적 거래대금 (UTC 0시 기준).
 * @property change 전일 대비 변화 (예: "RISE", "FALL").
 * @property changePrice 부호 없는 전일 대비 가격 변화.
 * @property signedChangePrice 전일 대비 가격 변화 (부호 포함).
 * @property changeRate 전일 대비 가격 변동률.
 * @property signedChangeRate 전일 대비 가격 변동률 (부호 포함).
 * @property askBid 매수/매도 구분.
 * @property tradeVolume 최근 24시간 거래량.
 * @property accTradeVolume 누적 거래량.
 * @property tradeDate 최근 거래 일자 (UTC).
 * @property tradeTime 최근 거래 시각 (UTC).
 * @property tradeTimestamp 최근 거래 타임스탬프.
 * @property accAskVolume 누적 매도량.
 * @property accBidVolume 누적 매수량.
 * @property highest52WeekPrice 52주 신고가.
 * @property highest52WeekDate 52주 신고가 달성일.
 * @property lowest52WeekPrice 52주 신저가.
 * @property lowest52WeekDate 52주 신저가 달성일.
 * @property marketState 마켓 상태.
 * @property isTradingSuspended 거래 정지 여부.
 * @property delistingDate 상장 폐지일.
 * @property marketWarning 유의 종목 여부.
 * @property timestamp 타임스탬프.
 * @property accTradePrice24h 최근 24시간 누적 거래대금 (UTC 0시 기준).
 * @property accTradeVolume24h 최근 24시간 누적 거래량 (UTC 0시 기준).
 * @property streamType 스트림 타입.
 */
@Serializable
data class TickerResponseDto(
    @SerialName("type")
    val type: String,
    @SerialName("code")
    val code: String,
    @SerialName("opening_price")
    val openingPrice: Double?,
    @SerialName("high_price")
    val highPrice: Double?,
    @SerialName("low_price")
    val lowPrice: Double?,
    @SerialName("trade_price")
    val tradePrice: Double?,
    @SerialName("prev_closing_price")
    val prevClosingPrice: Double?,
    @SerialName("acc_trade_price")
    val accTradePrice: Double?,
    @SerialName("change")
    val change: String?,
    @SerialName("change_price")
    val changePrice: Double?,
    @SerialName("signed_change_price")
    val signedChangePrice: Double?,
    @SerialName("change_rate")
    val changeRate: Double?,
    @SerialName("signed_change_rate")
    val signedChangeRate: Double?,
    @SerialName("ask_bid")
    val askBid: String?,
    @SerialName("trade_volume")
    val tradeVolume: Double,
    @SerialName("acc_trade_volume")
    val accTradeVolume: Double?,
    @SerialName("trade_date")
    val tradeDate: String?,
    @SerialName("trade_time")
    val tradeTime: String?,
    @SerialName("trade_timestamp")
    val tradeTimestamp: Long?,
    @SerialName("acc_ask_volume")
    val accAskVolume: Double?,
    @SerialName("acc_bid_volume")
    val accBidVolume: Double?,
    @SerialName("highest_52_week_price")
    val highest52WeekPrice: Double?,
    @SerialName("highest_52_week_date")
    val highest52WeekDate: String?,
    @SerialName("lowest_52_week_price")
    val lowest52WeekPrice: Double?,
    @SerialName("lowest_52_week_date")
    val lowest52WeekDate: String?,
    @SerialName("market_state")
    val marketState: String?,
    @SerialName("is_trading_suspended")
    val isTradingSuspended: Boolean?,
    @SerialName("delisting_date")
    @Contextual
    val delistingDate: Any?,
    @SerialName("market_warning")
    val marketWarning: String?,
    @SerialName("timestamp")
    val timestamp: Long?,
    @SerialName("acc_trade_price_24h")
    val accTradePrice24h: Double?,
    @SerialName("acc_trade_volume_24h")
    val accTradeVolume24h: Double?,
    @SerialName("stream_type")
    val streamType: String?
)
