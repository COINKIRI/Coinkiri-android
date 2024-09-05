package com.coinkiri.coinkiri.data.user.di

import com.coinkiri.coinkiri.data.user.datasource.UserDataSource
import com.coinkiri.coinkiri.data.user.datasourceimpl.UserDataSourceImpl
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
    abstract fun provideUserDataSource(userDataSourceImpl: UserDataSourceImpl): UserDataSource
}
