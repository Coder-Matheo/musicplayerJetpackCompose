package com.example.musicplayerjetpackcomposedemo

sealed class NavigationItem(var route: String, var icon: Int, var title: String){
    object Home: NavigationItem("home", R.drawable.ic_home, "Home")
    object Music: NavigationItem("music", R.drawable.ic_my_network, "Music")
    object Movies: NavigationItem("movies", R.drawable.ic_share, "Movies")
    object Books: NavigationItem("books", R.drawable.ic_job, "Books")
}
