package com.books.app.presentation.details.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.books.app.R
import com.books.app.data.models.Book

@Composable
fun SummarySection(currentBook: Book) {
    Text(
        text = stringResource(R.string.summary),
        fontSize = 20.sp,
        fontWeight = FontWeight(700),
        lineHeight = TextUnit(22f, TextUnitType.Sp),
        letterSpacing = TextUnit((-0.41f), TextUnitType.Sp),
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = currentBook.summary,
        fontSize = 14.sp,
        fontWeight = FontWeight(600),
        lineHeight = TextUnit(16.8f, TextUnitType.Sp),
        letterSpacing = TextUnit((0.15f), TextUnitType.Sp)
    )
}