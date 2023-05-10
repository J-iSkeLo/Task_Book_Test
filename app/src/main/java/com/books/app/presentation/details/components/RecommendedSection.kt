package com.books.app.presentation.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.books.app.R
import com.books.app.presentation.details.DetailsState
import com.books.app.ui.theme.PlaceholderColor
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
@OptIn(ExperimentalGlideComposeApi::class)
fun RecommendedSection(state: DetailsState) {
    Text(
        text = stringResource(R.string.you_will_also_like),
        fontSize = 20.sp,
        fontWeight = FontWeight(700),
        lineHeight = TextUnit(22f, TextUnitType.Sp),
        letterSpacing = TextUnit((-0.41f), TextUnitType.Sp),
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    LazyRow(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        items(state.likesBooks) { book ->
            Column(
                modifier = Modifier.width(120.dp)
            ) {
                GlideImage(
                    model = book.coverUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .width(120.dp)
                        .height(150.dp)
                        .background(
                            color = PlaceholderColor,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = book.name,
                    fontWeight = FontWeight(600),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    letterSpacing = TextUnit(0f, TextUnitType.Sp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}