package com.books.app.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.books.app.service.ConfigurationService
import com.books.app.utils.Constants
import com.books.app.utils.decodeDetailsData
import com.books.app.utils.decodeJsonData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DetailsViewModel(
    private val configService :ConfigurationService,
    savedStateHandle: SavedStateHandle,
) :ViewModel() {

    private val _state = MutableStateFlow(DetailsState())
    val state : StateFlow<DetailsState> = _state.asStateFlow()

    init {
        savedStateHandle.get<String>(Constants.BOOK_ID)?.let { bookId ->
            fetchBook(bookId.toInt())
        }
    }

    private fun fetchBook(bookId: Int) {
        val detailsData = configService.detailsCarousel.decodeDetailsData()
        val jsonData = configService.jsonData.decodeJsonData()?.likeSection ?: emptyList()

        if (detailsData == null) {
            _state.update {
                it.copy(errorMessage = "Something went wrong")
            }
        } else {
            val currentItem = detailsData.books.firstOrNull { it.id == bookId }
            val likesBooks = detailsData.books.filter { jsonData.contains(it.id) }

            _state.update {
                it.copy(
                    currentBook = currentItem,
                    books = detailsData.books,
                    likesBooks = likesBooks,
                    errorMessage = null
                )
            }
        }
    }
}