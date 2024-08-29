package com.coinkiri.coinkiri.data.coin.di

import com.coinkiri.coinkiri.data.coin.repositoryimpl.CoinRepositoryImpl
import com.coinkiri.coinkiri.domain.coin.repository.CoinRepository
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
    abstract fun provideCoinRepository(coinRepositoryImpl: CoinRepositoryImpl): CoinRepository
}
