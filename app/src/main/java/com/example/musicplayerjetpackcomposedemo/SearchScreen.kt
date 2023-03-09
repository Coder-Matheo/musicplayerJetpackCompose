package com.example.musicplayerjetpackcomposedemo

import android.app.Fragment
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.core.app.FrameMetricsAggregator

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    hint: String = ""
) {
    var query: String by rememberSaveable {
        mutableStateOf("")
    }
    var showClearIcon by rememberSaveable {
        mutableStateOf(hint != "")
    }

    var iconChangeClear by rememberSaveable {
        mutableStateOf(false)
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(
                color = Color(red = 98, green = 101, blue = 125), shape = RectangleShape
            )
            .onFocusChanged {
                showClearIcon = !it.hasFocus
                iconChangeClear = !iconChangeClear
            }
            .focusable(),

        value = query,
        onValueChange = { onQueryChanged ->
            query = onQueryChanged
            if (onQueryChanged.isNotEmpty()) {
                //Perform search
            }
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search Icon",
                tint = Color.White
            )
        },
        trailingIcon = {

            IconButton(onClick = {
                keyboardController?.hide()
            }) {
                if (iconChangeClear) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        contentDescription = "Clear Icon",
                        tint = Color.White
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_graphic_eq),
                        contentDescription = "Equalizer icon",
                        tint = Color.White
                    )
                }

            }

        },
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        placeholder = {
            Text(
                text = stringResource(id = R.string.hint_search_query),
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )
        },
        textStyle = MaterialTheme.typography.subtitle1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text, imeAction = ImeAction.Search
        ),


        )
}




