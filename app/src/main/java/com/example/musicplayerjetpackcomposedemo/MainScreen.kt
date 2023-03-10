package com.example.musicplayerjetpackcomposedemo

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {


    //LazyColumnScreen(imageMusic)

    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold(topBar = { TopBar() },
        drawerContent = {
                        NavigationDrawer(navController = navController)
        },
        drawerGesturesEnabled = true,
        floatingActionButton = {
            ExtendedFloatingActionButton(text = { Text(text = "snackbar") },
                onClick = {
                    scope.launch {
                        val result = scaffoldState.snackbarHostState
                            .showSnackbar(
                                message = "Snack bar",
                                actionLabel = "Action",
                                duration = SnackbarDuration.Indefinite
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {

                            }
                            SnackbarResult.Dismissed -> {

                            }
                        }
                    }
                })
            /*FloatingActionButton(onClick = {}) {
                Text(text = "+")
            }*/
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        content = {
            Navigation(navController = navController)
        },

        bottomBar = {

            BottomAppBar(
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {
                BottomNavigationBar(navController)
            }

        })

}


@Preview
@Composable
fun mainScreenPreview() {
    MainScreen()
}


