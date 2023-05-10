package com.books.app.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val books: List<Book>,
    @SerialName("top_banner_slides")
    val topBannerSlides: List<TopBannerSlide>,
    @SerialName("you_will_like_section")
    val likeSection: List<Int>
)