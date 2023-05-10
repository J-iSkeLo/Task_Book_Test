package com.books.app.presentation.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.books.app.R
import com.books.app.navigation.Screens
import com.books.app.presentation.splash.components.ProgressBar
import com.books.app.ui.theme.AppColor
import com.books.app.ui.theme.Georgia

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel
) {
    val animatedProgress = remember { Animatable(0f) }

    LaunchedEffect(key1 = Unit) {
        animatedProgress.animateTo(
            100f,
            animationSpec = tween(durationMillis = 2000, delayMillis = 0, easing = LinearEasing)
        )

        navController.navigate(Screens.MainScree.route) {
            popUpTo(Screens.SplashScreen.route) {
                inclusive = true
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.img_background),
            contentDescription = "Background image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.book_app),
                fontFamily = Georgia,
                fontSize = 52.sp,
                color = AppColor,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = stringResource(R.string.welcome),
                color = Color.White,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(40.dp))
            ProgressBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .padding(horizontal = 50.dp),
                animatedProgress = animatedProgress
            )
        }
    }
}