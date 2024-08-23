package com.coinkiri.coinkiri.data.token.di

import com.coinkiri.coinkiri.data.token.repositoryimpl.TokenRepositoryImpl
import com.coinkiri.coinkiri.domain.token.repository.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TokenRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTokenRepository(tokenRepositoryImpl: TokenRepositoryImpl): TokenRepository
}
