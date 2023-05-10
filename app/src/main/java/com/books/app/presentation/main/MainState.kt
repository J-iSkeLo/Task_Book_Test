package com.books.app.presentation.main

import com.books.app.data.models.Data

data class MainState(
    val data : Data? = null,
    val errorMessage :String? = null
)
