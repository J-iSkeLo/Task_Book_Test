package com.books.app.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.books.app.data.models.Book
import com.books.app.data.models.TopBannerSlide
import com.books.app.navigation.Screens
import com.books.app.presentation.main.components.BookTopCarousel
import com.books.app.presentation.main.components.BooksRecyclerLazy
import com.books.app.presentation.main.components.TitleText
import com.books.app.utils.toast

@Composable
fun MainScreen(
    navController: NavController,
    viewModel : MainViewModel
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()

    val topBannerSlides = remember {  mutableStateOf(emptyList<TopBannerSlide>()) }
    val books = remember { mutableStateOf(mapOf<String, List<Book>>()) }

    LaunchedEffect(key1 = state) {
        state.data?.let { data ->
            topBannerSlides.value = data.topBannerSlides
            books.value = data.books.groupBy { it.genre }
        }

        state.errorMessage?.let { message ->
            context.toast(message)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(38.dp))
        TitleText()
        Spacer(modifier = Modifier.height(28.dp))
        BookTopCarousel(
            topBannerSlides,
            onClick = { bookId ->
                navigateToDetails(navController, bookId)
            }
        )
        Spacer(modifier = Modifier.height(35.dp))
        BooksRecyclerLazy(
            books,
            onClick = { bookId ->
                navigateToDetails(navController, bookId)
            }
        )
    }
}

private fun navigateToDetails(navController: NavController, bookId: Int) {
    navController.navigate(Screens.DetailsScreen.route + "/${bookId}")
}



