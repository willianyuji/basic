package com.willianmaesato.login.presentation.di

import com.willianmaesato.core.navigation.NavigationFactory
import com.willianmaesato.login.presentation.LoginNavigationFactory
import com.willianmaesato.login.presentation.LoginUiState
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object RocketsViewModelModule {

    @Provides
    fun provideInitialLoginUiState(): LoginUiState = LoginUiState()
}

@Module
@InstallIn(SingletonComponent::class)
interface LoginSingletonProvider {

    @Singleton
    @Binds
    @IntoSet
    fun bindLoginNavigationFactory(factory: LoginNavigationFactory): NavigationFactory
}
