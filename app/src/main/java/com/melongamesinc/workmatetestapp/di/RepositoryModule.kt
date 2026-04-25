package com.melongamesinc.workmatetestapp.di

import com.melongamesinc.workmatetestapp.data.api.StarWarsApi
import com.melongamesinc.workmatetestapp.data.db.CharacterDao
import com.melongamesinc.workmatetestapp.data.impl.CharacterRepositoryImpl
import com.melongamesinc.workmatetestapp.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCharacterRepository(
        api: StarWarsApi,
        dao: CharacterDao
    ): CharacterRepository {
        return CharacterRepositoryImpl(api, dao)
    }
}