package com.example.musicplayerjetpackcomposedemo

open class BottomNavItem(var name: String, var route: String, var icon: Int){
    object Home : BottomNavItem("Home", "home", R.drawable.ic_home)
    object Create : BottomNavItem("Create", "create", R.drawable.ic_share)
    object Settings : BottomNavItem("Settings", "settings", R.drawable.ic_my_network)

}