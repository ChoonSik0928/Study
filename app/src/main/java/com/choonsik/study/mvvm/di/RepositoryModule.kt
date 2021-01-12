package com.choonsik.study.mvvm.di

import com.choonsik.study.mvvm.data.domain.mapper.BreedMapper
import com.choonsik.study.mvvm.data.network.BreedService
import com.choonsik.study.mvvm.data.repository.BreedRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideBreedMapper(): BreedMapper {
        return BreedMapper()
    }

    @Singleton
    @Provides
    fun provideBreedRepository(
        breedService: BreedService,
        breedMapper: BreedMapper
    ): BreedRepository = BreedRepository(breedService, breedMapper)
}