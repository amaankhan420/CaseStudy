package com.example.foodzz.composables

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.foodzz.data_classes.OfferCollection

@Composable
fun OffersCollection(offerCollections: List<OfferCollection>?) {
    var index = 0
    Column (
        modifier = Modifier
            .padding(top = 12.dp, bottom = 5.dp, start = 8.dp, end = 8.dp)
    ){
        Text(
            text = "Collection",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(start = 15.dp, bottom = 10.dp)
        )
        while (index < (offerCollections?.size ?: 0)) {
            OfferRow(offerCollections?.subList(index, minOf(index + 2, offerCollections.size)) ?: emptyList())
            Spacer(modifier = Modifier.height(8.dp))
            index += 2
        }
    }
}

@Composable
fun OfferRow(rowItems: List<OfferCollection>) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.Center
    ) {
        for (offerCollection in rowItems) {
            Cards(offerCollection)
        }
    }
}

@Composable
fun Cards(offerCollection: OfferCollection) {
    ElevatedCard(
        modifier = Modifier
            .size(width = 200.dp, height = 50.dp)
            .padding(horizontal = 15.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(parseColor("#${offerCollection.background}"))),
        ) {
            Image(
                painter = rememberAsyncImagePainter(offerCollection.image),
                contentDescription = "Image",
                modifier = Modifier
                    .size(70.dp, 50.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White),
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = offerCollection.name,
                color = Color(parseColor("#${offerCollection.textColor}")),
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}