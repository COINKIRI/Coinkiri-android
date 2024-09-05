package com.coinkiri.coinkiri.data.user.di

import com.coinkiri.coinkiri.core.network.JWT
import com.coinkiri.coinkiri.data.user.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideUserService(@JWT retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)
}
