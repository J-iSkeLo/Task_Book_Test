package com.books.app.data.models

import kotlinx.serialization.Serializable

@Serializable
data class DetailsData(
    val books: List<Book>
)