package com.coinkiri.coinkiri.data.user.di

import com.coinkiri.coinkiri.data.user.repositoryimpl.UserRepositoryImpl
import com.coinkiri.coinkiri.domain.user.repository.UserRepository
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
    abstract fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}