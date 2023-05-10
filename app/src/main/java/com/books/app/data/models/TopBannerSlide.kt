package com.books.app.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopBannerSlide(
    @SerialName("book_id")
    val bookId: Int,
    val cover: String,
    val id: Int
)