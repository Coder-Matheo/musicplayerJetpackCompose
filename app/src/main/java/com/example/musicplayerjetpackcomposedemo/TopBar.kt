package com.example.musicplayerjetpackcomposedemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    color: Color = Color.Red
) {

    TopAppBar(
        title = {
            Column() {
                Text(
                    text = "Welcome To",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.alpha(0.5f)
                )
                Text(
                    text = "Radio AVA",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Serif

                )
            }
        },
        backgroundColor = Color.Black,
        actions = {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(shape = CircleShape)
                    .size(40.dp)
                    .background(Color.DarkGray)
                    .border(1.dp, Color.Gray, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_antenna),
                    contentDescription = null
                )

            }
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(shape = CircleShape)
                    .size(40.dp)
                    .background(Color.DarkGray)
                    .border(1.dp, Color.Gray, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = null
                )

            }
        }


    )
}