package com.coinkiri.coinkiri.data.ticker.di

import com.coinkiri.coinkiri.data.ticker.repositoryimpl.TickerRepositoryImpl
import com.coinkiri.coinkiri.domain.coin.repository.TickerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideTickerRepository(tickerRepositoryImpl: TickerRepositoryImpl): TickerRepository
}
