package com.books.app.presentation.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.books.app.R
import com.books.app.data.models.Book

@Composable
fun InfoSection(currentBook: Book) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RowText(currentBook.views)
            RowHint(stringResource(R.string.readers))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RowText(currentBook.likes)
            RowHint(stringResource(R.string.likes))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RowText(currentBook.quotes)
            RowHint(stringResource(R.string.quotes))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RowText(currentBook.genre)
            RowHint(stringResource(R.string.genre))
        }
    }
}