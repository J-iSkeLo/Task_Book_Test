package com.books.app.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.books.app.service.ConfigurationService
import com.books.app.utils.decodeJsonData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val configService: ConfigurationService
) : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state :StateFlow<MainState> = _state.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val data = configService.jsonData.decodeJsonData()

            _state.update {
                it.copy(
                    data = data,
                    errorMessage = if (data == null)
                        "Something went wrong" /* Exception example if API return BadRequest*/
                    else null
                )
            }
        }
    }
}