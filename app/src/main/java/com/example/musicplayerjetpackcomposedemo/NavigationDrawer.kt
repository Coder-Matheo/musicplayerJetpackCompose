package com.example.musicplayerjetpackcomposedemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicplayerjetpackcomposedemo.ui.theme.Purple500
import kotlinx.coroutines.launch


@Composable
fun NavigationDrawer(
    navController: NavHostController
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()


    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = R.drawable.ic_home
        ),
        BottomNavItem(
            name = "Create",
            route = "create",
            icon = R.drawable.ic_my_network
        ),
        BottomNavItem(
            name = "Settings",
            route = "settings",
            icon = R.drawable.ic_share
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(126.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Column() {
                Image(
                    modifier = Modifier
                        .scale(1.4f),
                    painter = painterResource(id = R.drawable.ic_job),
                    contentDescription = ""
                )

                Image(
                    modifier = Modifier
                        .scale(1.4f),
                    painter = painterResource(id = R.drawable.ic_share),
                    contentDescription = ""
                )
            }

        }
        Spacer(modifier = Modifier.height(24.dp))

        bottomNavItems.forEach { item ->
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = item.route == navBackStackEntry?.destination?.route

            val selected = item.route //== backStackEntry.value?.destination?.route

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .clickable {
                        coroutineScope.launch {
                            scaffoldState.drawerState.close()
                        }
                        navController.navigate(item.route)
                    },
                backgroundColor = if (currentRoute) Purple500 else Color.White,
                elevation = 0.dp,
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        contentDescription = "${item.name} Icon"
                    )
                    Text(modifier = Modifier
                        .padding(start = 24.dp),
                        text = item.name
                    )
                }
            }
        }


    }

}

@Composable
@Preview
fun NavDrawerPreview() {
    val navController = rememberNavController()
    NavigationDrawer(navController = navController)
}