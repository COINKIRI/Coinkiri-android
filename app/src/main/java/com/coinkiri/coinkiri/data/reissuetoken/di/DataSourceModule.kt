package com.coinkiri.coinkiri.data.reissuetoken.di

import com.coinkiri.coinkiri.data.reissuetoken.datasource.ReissueTokenDataSource
import com.coinkiri.coinkiri.data.reissuetoken.datasourceimpl.ReissueTokenDataSourceImpl
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
    abstract fun bindReissueTokenDataSource(reissueTokenDataSourceImpl: ReissueTokenDataSourceImpl): ReissueTokenDataSource
}
