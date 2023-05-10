package com.books.app.presentation.main.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.books.app.data.models.TopBannerSlide
import com.books.app.ui.theme.AppColor
import com.books.app.ui.theme.InactiveIndicatorColor
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.accompanist.pager.HorizontalPagerIndicator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalFoundationApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun BookTopCarousel(
    books: MutableState<List<TopBannerSlide>>,
    onClick : (Int) -> Unit
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pagerState) {
        while (true) {
            if (books.value.isNotEmpty()) {
                delay(3.seconds)
                coroutineScope.launch {
                    pagerState.animateScrollToPage((pagerState.currentPage + 1) % books.value.size)
                }
            } else {
                delay(5.seconds)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(horizontal = 16.dp)
    ) {
        HorizontalPager(
            pageCount = books.value.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    shape = RoundedCornerShape(20.dp),
                    color = Color.Black
                )
                .clip(RoundedCornerShape(20.dp)),
        ) { page ->
            val book = books.value[page]
            GlideImage(
                model = book.cover,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { onClick(book.bookId) },
                contentScale = ContentScale.Crop
            )
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            pageCount = books.value.size,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            inactiveColor = InactiveIndicatorColor,
            activeColor = AppColor
        )
    }
}
