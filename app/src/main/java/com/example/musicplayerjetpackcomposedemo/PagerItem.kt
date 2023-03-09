package com.example.musicplayerjetpackcomposedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Composable
fun PagerItemScreen(imageUrl: Int, count: Int) {
    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = "image",
            modifier = Modifier
                .requiredWidth(360.dp)
                .clip(RoundedCornerShape(30.dp))

        ) {

            val state = painter.state

            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                CircularProgressIndicator()

            } else {
                SubcomposeAsyncImageContent()
            }
        }
        
        Text(text = "Name Of Sound",
            modifier = Modifier
                .padding(30.dp)
                .align(Alignment.TopStart)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Gray),
            fontWeight = FontWeight.Bold,
            color = Color.White

        )
    }
}


