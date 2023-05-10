package com.books.app.service

interface ConfigurationService {
    suspend fun fetchConfiguration(): Boolean
    val jsonData :String
    val detailsCarousel :String
}