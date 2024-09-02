package com.coinkiri.coinkiri.data.ticker.di

import com.coinkiri.coinkiri.data.ticker.datasource.TickerDataSource
import com.coinkiri.coinkiri.data.ticker.datasourceimpl.TickerDataSourceImpl
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
    abstract fun provideTickerDataSource(tickerDataSourceImpl: TickerDataSourceImpl): TickerDataSource
}
