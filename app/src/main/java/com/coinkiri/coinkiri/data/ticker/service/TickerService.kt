package com.coinkiri.coinkiri.data.ticker.service

import com.coinkiri.coinkiri.BuildConfig
import com.coinkiri.coinkiri.core.network.WEBSOCKET
import com.coinkiri.coinkiri.data.ticker.dto.request.TickerRequestDto
import com.coinkiri.coinkiri.data.ticker.dto.response.TickerResponseDto
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString
import timber.log.Timber
import java.util.UUID
import javax.inject.Inject

class TickerService @Inject constructor(
    @WEBSOCKET private val okHttpClient: OkHttpClient,
    private val json: Json
) {
    private lateinit var webSocket: WebSocket

    fun startConnection(tickerRequestDto: TickerRequestDto): Flow<TickerResponseDto> =
        callbackFlow {
            val request = Request.Builder()
                .url(BuildConfig.UPBIT_SOCKET_URL)
                .build()

            webSocket = okHttpClient.newWebSocket(
                request,
                createWebSocketListener(
                    tickerRequestDto = tickerRequestDto,
                    onTickerReceived = { tickerResponseDto ->
                        trySend(tickerResponseDto).isSuccess
                    }
                )
            )

            awaitClose {
                closeConnection()
            }
        }

    fun closeConnection() {
        if (this::webSocket.isInitialized) {
            webSocket.close(CLOSE_CODE, null)
        }
    }

    private fun createWebSocketListener(
        tickerRequestDto: TickerRequestDto,
        onTickerReceived: (TickerResponseDto) -> Unit,
    ) = object : WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
            val uniqueTicket = UUID.randomUUID().toString()
            val json = """
                        [
                            {
                                "ticket":"$uniqueTicket"
                            },
                            {
                                "type":"${tickerRequestDto.type}",
                                "codes":[
                                    ${tickerRequestDto.codes}
                                ]
                            }
                        ]
                """.trimIndent()
            webSocket.send(json)
        }

        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            val jsonString = bytes.utf8()
            val tickerResponseDto = parseResponse(jsonString)
            onTickerReceived(tickerResponseDto)
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) =
            Timber.d("Socket Closed: $code / $reason")

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) =
            Timber.d("Socket Error: ${t.message}")
    }

    private fun parseResponse(jsonResponse: String): TickerResponseDto =
        json.decodeFromString<TickerResponseDto>(jsonResponse)

    private companion object {
        private const val CLOSE_CODE = 1000
    }
}
