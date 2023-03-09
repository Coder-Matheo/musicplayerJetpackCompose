package com.example.musicplayerjetpackcomposedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {


    val imageMusic = listOf(
        RinkingMusicData(
            nameMusic = "Sogand",
            imageVector = R.drawable.color_back,
            "Image profile"
        ),
        RinkingMusicData(
            nameMusic = "Sogand",
            imageVector = R.drawable.color_back,
            "Image profile"
        ),
        RinkingMusicData(
            nameMusic = "Sogand",
            imageVector = R.drawable.brandenburger_pic,
            "Image profile"
        ),
        RinkingMusicData(
            nameMusic = "Sogand",
            imageVector = R.drawable.color_back,
            "Image profile"
        ),
        RinkingMusicData(
            nameMusic = "Sogand",
            imageVector = R.drawable.color_back,
            "Image profile"
        )
    )


    //LazyColumnScreen(imageMusic)

    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    Scaffold(topBar = { TopBar() },
        drawerContent = { },
        floatingActionButton = {
            ExtendedFloatingActionButton(text = { Text(text = "Show snackbar") },
                onClick = {
                    scope.launch {
                        val result = scaffoldState.snackbarHostState
                            .showSnackbar(
                                message = "Snack bar",
                                actionLabel = "Action",
                                duration = SnackbarDuration.Indefinite
                            )
                        when(result){
                            SnackbarResult.ActionPerformed ->{

                            }
                            SnackbarResult.Dismissed -> {

                            }
                        }
                    }
                })
            FloatingActionButton(onClick = {}) {
                Text(text = "+")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {

            BottomAppBar(
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {
                BottomNavigationBar(navController)
            }

        }) {
        Column(
            modifier = Modifier
                .background(Color(red = 28, green = 31, blue = 43))

        ) {
            SearchScreen()

            HorizontalPagerScreen()
            LazyColumnScreen(imageMusic = imageMusic)
        }

    }


}


@Preview
@Composable
fun mainScreenPreview() {
    MainScreen()
}


