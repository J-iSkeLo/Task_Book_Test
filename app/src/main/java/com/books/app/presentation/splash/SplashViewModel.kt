package com.books.app.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.books.app.service.ConfigurationService
import kotlinx.coroutines.launch

class SplashViewModel(
    configService: ConfigurationService
) :ViewModel() {

    init {
        viewModelScope.launch { configService.fetchConfiguration() }
    }
}