package com.books.app.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.books.app.presentation.details.DetailsScreen
import com.books.app.presentation.main.MainScreen
import com.books.app.presentation.splash.SplashScreen
import com.books.app.utils.Constants.ANIM_DURATION
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.androidx.compose.koinViewModel

@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()

    val slideLeft = AnimatedContentTransitionScope.SlideDirection.Left
    val slideRight = AnimatedContentTransitionScope.SlideDirection.Right

    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route,
        enterTransition = { slideIntoContainer(slideLeft, animationSpec = tween(ANIM_DURATION)) },
        exitTransition = { slideOutOfContainer(slideLeft, animationSpec = tween(ANIM_DURATION)) },
        popEnterTransition = { slideIntoContainer(slideRight, animationSpec = tween(ANIM_DURATION)) },
        popExitTransition = { slideOutOfContainer(slideRight, animationSpec = tween(ANIM_DURATION)) },
    ) {
        composable(Screens.SplashScreen.route) { SplashScreen(navController, koinViewModel()) }
        composable(Screens.MainScree.route) { MainScreen(navController, koinViewModel()) }
        composable(Screens.DetailsScreen.route + "/{bookId}") {
            DetailsScreen(navController, koinViewModel())
        }
    }
}