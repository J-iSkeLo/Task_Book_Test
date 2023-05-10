package com.books.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.books.app.R

val NunitoSans = FontFamily(
    Font(R.font.nunito_sans_regular),
    Font(R.font.nunito_sans_bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = (16.8).sp,
        letterSpacing = (-2).sp
    ),
    titleLarge = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 22.sp,
        letterSpacing = (-5).sp
    )
)

val Georgia = FontFamily(
    Font(R.font.georgia_bold_italic)
)

val TypographyGeorgia = Typography(
    titleLarge = TextStyle(
        fontFamily = Georgia,
        fontWeight = FontWeight.Bold,
        fontSize = 52.sp,
        lineHeight = 52.sp,
        letterSpacing = (-7).sp
    )
)