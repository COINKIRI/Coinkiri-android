package com.coinkiri.coinkiri.data.ticker.di

import com.coinkiri.coinkiri.core.network.WEBSOCKET
import com.coinkiri.coinkiri.data.ticker.service.TickerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideTickerService(
        @WEBSOCKET okHttpClient: OkHttpClient,
        json: Json
    ): TickerService =
        TickerService(okHttpClient, json)
}
