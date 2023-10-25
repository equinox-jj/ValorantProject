package com.valorantproject.di

import com.valorantproject.core.data.repository.AgentRepository
import com.valorantproject.core.data.repository.AgentRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideAgentRepository(impl: AgentRepositoryImpl): AgentRepository

}