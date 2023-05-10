package com.books.app.presentation.details

import com.books.app.data.models.Book

data class DetailsState(
    val currentBook :Book? = null,
    val books :List<Book> = emptyList(),
    val likesBooks :List<Book> = emptyList(),
    val errorMessage :String? = null
)