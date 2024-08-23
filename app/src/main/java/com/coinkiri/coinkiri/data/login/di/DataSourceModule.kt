package com.coinkiri.coinkiri.data.login.di

import com.coinkiri.coinkiri.data.login.datasource.LoginDataSource
import com.coinkiri.coinkiri.data.login.datasourceimpl.LoginDataSourceImpl
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
    abstract fun provideLoginDataSource(loginDataSourceImpl: LoginDataSourceImpl): LoginDataSource
}
