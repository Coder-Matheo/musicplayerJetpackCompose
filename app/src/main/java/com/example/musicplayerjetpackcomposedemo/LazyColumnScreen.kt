package com.example.musicplayerjetpackcomposedemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyColumnScreen(imageMusic: List<RinkingMusicData>) {


    Card(elevation = 2.dp,
        modifier = Modifier
            .padding(10.dp)
        ) {
        LazyRow(
            modifier = Modifier
                .background(Color(red = 28, green = 31, blue = 43))


        ) {
            items(imageMusic) { item ->
                MyCard(item.nameMusic, item.imageVector, item.descriptionImage)
            }
        }
    }
}

@Composable
fun MyCard(mName: String, mImage: Int, mDescription: String) {
    Row(
        modifier = Modifier
            .width(80.dp)
            .height(90.dp)
            .padding( 10.dp)
            ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .border(1.dp, Color.White, shape = RoundedCornerShape(10.dp))
                ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ) {
            Image(
                painter = painterResource(id = mImage),
                modifier = Modifier
                    .fillMaxWidth(),
                contentDescription = mDescription
            )
            Text(
                text = mName,
                color = Color.White,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }


    }


    /*Card(
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .background(Color.Green)
            .width(100.dp)
            .height(60.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = 1.dp
    ) {

    }*/
}