package com.books.app.navigation

sealed class Screens(val route :String) {
    object SplashScreen : Screens("splash_screen")
    object MainScree : Screens("main_screen")
    object DetailsScreen : Screens("details_screen")
}