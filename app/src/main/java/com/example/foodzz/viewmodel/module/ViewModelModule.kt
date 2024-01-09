package com.example.foodzz.viewmodel.module

import androidx.lifecycle.ViewModelProvider
import com.example.foodzz.repository.HomeRepository
import com.example.foodzz.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @ViewModelScoped
    @Provides
    fun provideHomeViewModel(
        repository: HomeRepository
    ): HomeViewModel {
        return HomeViewModel(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideViewModelFactory(
        repository: HomeRepository
    ): ViewModelProvider.Factory {
        return ViewModelFactory(repository)
    }
}