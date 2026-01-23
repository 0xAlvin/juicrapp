package com.example.juicr.di

import com.example.juicr.JuiceRepositoryImpl
import com.example.juicr.repositories.IJuiceRepository
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
    abstract fun bindJuiceRepository(
        impl: JuiceRepositoryImpl
    ): IJuiceRepository

}