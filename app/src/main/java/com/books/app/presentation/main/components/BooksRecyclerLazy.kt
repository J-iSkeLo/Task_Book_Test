package com.books.app.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.books.app.data.models.Book
import com.books.app.ui.theme.PlaceholderColor
import com.books.app.ui.theme.WhiteTranslucent
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BooksRecyclerLazy(
    books: MutableState<Map<String, List<Book>>>,
    onClick: (Int) -> Unit
) {
    books.value.onEach { genre ->
        Text(
            text = genre.key,
            color = Color.White,
            fontWeight = FontWeight(700),
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            items(genre.value) { book ->
                Column(
                    modifier = Modifier
                        .width(120.dp)
                        .clickable {
                            onClick(book.id)
                        }
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
                        color = WhiteTranslucent,
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
        Spacer(modifier = Modifier.height(26.dp))
    }
}