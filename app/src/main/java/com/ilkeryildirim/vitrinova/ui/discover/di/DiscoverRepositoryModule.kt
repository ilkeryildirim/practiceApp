package com.ilkeryildirim.vitrinova.ui.discover.di

import com.ilkeryildirim.vitrinova.ui.discover.DiscoverDataRepository
import com.ilkeryildirim.vitrinova.ui.discover.DiscoverDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DiscoverRepositoryModule {

    @Binds
    abstract fun bindDiscoverDataRepository(
            analyticsServiceImpl: DiscoverDataRepositoryImpl
    ): DiscoverDataRepository

}