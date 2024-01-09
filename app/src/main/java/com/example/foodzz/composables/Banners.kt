package com.example.foodzz.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.foodzz.data_classes.Banner

@Composable
fun Banners(
    banners: List<Banner>?
) {
   Row (
       modifier = Modifier
           .padding(top = 3.dp, bottom = 5.dp, start = 5.dp, end = 5.dp)
           .horizontalScroll(rememberScrollState())
   ) {
       banners?.forEach { banner ->
           BannerImage(banner.imageUrl)
       }
   }
}

@Composable
fun BannerImage(imageUrl: String?) {
    Surface(
        modifier = Modifier.padding(4.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "Banner",
            modifier = Modifier
                .size(width = 300.dp, height = 100.dp),
            contentScale = ContentScale.Crop
        )
    }
}