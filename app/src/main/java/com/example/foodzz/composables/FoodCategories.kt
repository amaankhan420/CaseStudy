package com.example.foodzz.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.foodzz.data_classes.FoodCategory

@Composable
fun FoodCategories(foodCategories: List<FoodCategory>?) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 5.dp, start = 8.dp, end = 8.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        foodCategories?.forEach { foodCategory ->
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                FoodImage(foodCategory.icon)
                Text(text = foodCategory.name, color = Color.Gray)
            }
        }
    }
}

@Composable
fun FoodImage(category: String) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(width = 90.dp, height = 90.dp)
            .clip(CircleShape)
            .background(Color.Transparent)
    ) {
        Image(
            painter = rememberAsyncImagePainter(category),
            contentDescription = "Food",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
