package com.coinkiri.coinkiri.data.coin.di

import com.coinkiri.coinkiri.data.coin.datasource.CoinDataSource
import com.coinkiri.coinkiri.data.coin.datasourceimpl.CoinDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun provideCoinDataSource(coinDataSourceImpl: CoinDataSourceImpl): CoinDataSource
}
