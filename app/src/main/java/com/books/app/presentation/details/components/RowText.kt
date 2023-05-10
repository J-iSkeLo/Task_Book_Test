package com.books.app.presentation.details.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

@Composable
fun RowText(text :String) = Text(
    text = text,
    fontSize = 18.sp,
    fontWeight = FontWeight(700),
    lineHeight = TextUnit(22f, TextUnitType.Sp),
    letterSpacing = TextUnit((-0.41f), TextUnitType.Sp)
)