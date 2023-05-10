package com.books.app.di

import androidx.lifecycle.SavedStateHandle
import com.books.app.presentation.details.DetailsViewModel
import com.books.app.presentation.main.MainViewModel
import com.books.app.presentation.splash.SplashViewModel
import com.books.app.service.ConfigurationService
import com.books.app.service.impl.ConfigurationServiceImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviceModule = module {
    single<ConfigurationService> { ConfigurationServiceImpl() }
}

val viewModelsModule = module {
    viewModel { MainViewModel( get() ) }
    viewModel { SplashViewModel( get() ) }
    viewModel { (handle: SavedStateHandle) -> DetailsViewModel(get(), handle) }
}