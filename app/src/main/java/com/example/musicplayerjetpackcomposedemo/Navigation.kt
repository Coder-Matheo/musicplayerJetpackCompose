package com.example.musicplayerjetpackcomposedemo

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route
    ){
        composable(NavigationItem.Home.route){
            Log.i("TAG", "Navigation: ")
            HomeScreen()
        }
        composable(NavigationItem.Music.route){
            MusicScreen()
        }
        composable(NavigationItem.Movies.route){
            MoviesScreen()
        }
        composable(NavigationItem.Books.route){
            BooksScreen()
        }
    }
}