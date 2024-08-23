package com.coinkiri.coinkiri.data.reissuetoken.di

import com.coinkiri.coinkiri.data.reissuetoken.repositoryimpl.ReissueTokenRepositoryImpl
import com.coinkiri.coinkiri.domain.reissuetoken.repository.ReissueTokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ReissueTokenRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindReissueTokenRepository(reissueTokenRepositoryImpl: ReissueTokenRepositoryImpl): ReissueTokenRepository
}
