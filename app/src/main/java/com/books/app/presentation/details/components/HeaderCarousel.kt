package com.books.app.presentation.details.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.books.app.presentation.details.DetailsState
import com.books.app.ui.theme.BackgroundTopColor
import com.books.app.ui.theme.WhiteTranslucent
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kotlin.math.absoluteValue

@Composable
@OptIn(ExperimentalGlideComposeApi::class, ExperimentalFoundationApi::class)
fun HeaderCarousel(
    state: DetailsState,
    pagerState: PagerState
) {
    HorizontalPager(
        pageCount = state.books.size,
        state = pagerState,
        pageSpacing = 0.dp,
        contentPadding = PaddingValues(horizontal = 95.dp),
        modifier = Modifier.fillMaxWidth().height(350.dp)
    ) { page ->
        val book = state.books[page]
        Card(
            Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page, pagerState).absoluteValue
                    lerp(
                        start = Offset(0.8f, 0.75f),
                        stop = Offset(1f, 1f),
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        scaleX = scale.x
                        scaleY = scale.y
                    }
                },
            colors = CardDefaults.cardColors(containerColor = BackgroundTopColor)
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                GlideImage(
                    model = book.coverUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .width(200.dp)
                        .height(250.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = book.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    letterSpacing = TextUnit((-0.41f), TextUnitType.Sp),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = book.author,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700),
                    letterSpacing = TextUnit((-0.41f), TextUnitType.Sp),
                    color = WhiteTranslucent,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
fun calculateCurrentOffsetForPage(
    page :Int,
    pagerState: PagerState
) :Float {
    return (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
}