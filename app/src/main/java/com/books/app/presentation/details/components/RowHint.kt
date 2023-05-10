package com.books.app.presentation.details.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.books.app.ui.theme.HintColor

@Composable
fun RowHint(text :String) = Text(
    text = text,
    fontSize = 12.sp,
    fontWeight = FontWeight(600),
    lineHeight = TextUnit(13f, TextUnitType.Sp),
    letterSpacing = TextUnit((-0.41f), TextUnitType.Sp),
    color = HintColor
)