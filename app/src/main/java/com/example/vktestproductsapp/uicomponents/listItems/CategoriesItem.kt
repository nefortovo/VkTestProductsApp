package com.example.vktestproductsapp.uicomponents.listItems

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoriesItem(
    modifier: Modifier = Modifier,
    category: String,
) {
    Column(modifier = modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            Icons.Rounded.Info,
            modifier = Modifier
                .size(60.dp)
                .clip(shape = CircleShape)
                .background(Color.White)
                .padding(10.dp),
            contentDescription = null
        )
        Text(text = category)
    }
}