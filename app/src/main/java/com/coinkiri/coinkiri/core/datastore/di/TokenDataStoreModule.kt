package com.coinkiri.coinkiri.core.datastore.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.coinkiri.coinkiri.core.datastore.TokenDataStore
import com.coinkiri.coinkiri.core.datastore.TokenDataStoreImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TokenDataStoreModule {

    @Provides
    @Singleton
    fun provideTokenDataStoreImpl(@Named("token") dataStore: DataStore<Preferences>): TokenDataStore =
        TokenDataStoreImpl(dataStore)
}
