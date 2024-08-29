package com.coinkiri.coinkiri.data.coin.di

import com.coinkiri.coinkiri.core.network.JWT
import com.coinkiri.coinkiri.data.coin.service.CoinService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideCoinService(@JWT retrofit: Retrofit): CoinService =
        retrofit.create(CoinService::class.java)
}
