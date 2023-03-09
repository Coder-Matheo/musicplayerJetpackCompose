package com.example.musicplayerjetpackcomposedemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerScreen() {

    val imageList = Constants.imageList
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            

    ) {
        HorizontalPager(count = imageList.size, state = pagerState) { page ->
            PagerItemScreen(imageUrl = imageList[page], page)
        }
    }

    LaunchedEffect(key1 = pagerState,
        block = {
            pagerState.animateScrollToPage(0)
        })

}