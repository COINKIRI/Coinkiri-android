package com.coinkiri.coinkiri.data.login.di

import com.coinkiri.coinkiri.data.login.repositoryimpl.LoginRepositoryImpl
import com.coinkiri.coinkiri.domain.login.repository.LoginRepository
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
    abstract fun provideLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository
}
