package com.example.foodzz.composables

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.foodzz.data_classes.Restaurant
import com.example.foodzz.data_classes.RestaurantCollection

@Composable
fun Restaurant(restaurantCollections: List<RestaurantCollection>?) {
    restaurantCollections?.get(1)?.let { Section(it) }
    restaurantCollections?.get(0)?.let { Section(it) }
}

@Composable
fun Section(restaurantCollection: RestaurantCollection) {
    Column (
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
        ){
            Text(
                text = restaurantCollection.name,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .padding(start = 15.dp, bottom = 10.dp)
            )
            TextButton(
                onClick = {  },
            ) {
                Text(
                    text = "View More",
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    fontStyle = FontStyle.Italic
                )
            }
        }

        Row (
            modifier = Modifier
                .padding(top = 3.dp, bottom = 5.dp, start = 5.dp, end = 5.dp)
                .horizontalScroll(rememberScrollState())
        ){
            restaurantCollection.restaurants.forEach { restaurant ->
                Cards(restaurant = restaurant)
            }
        }
    }
}

@Composable
fun Cards(restaurant: Restaurant) {
    ElevatedCard(
        modifier = Modifier
            .size(width = 180.dp, height = 220.dp)
            .padding(horizontal = 8.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ){
        Column {
            Box {
                Image(
                    painter = rememberAsyncImagePainter(restaurant.imageUrl),
                    contentDescription = "Restaurant",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .background(Color.White),
                    contentScale = ContentScale.Crop
                )

                if (restaurant.additionalOffer?.isNotEmpty() == true) {
                    Box (
                        modifier = Modifier
                            .size(width = 90.dp, height = 30.dp)
                            .background(Color.Green)
                    ){
                        Text(
                            text = restaurant.additionalOffer,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            Text(
                text = restaurant.name,
                fontSize = 15.sp,
                color = Color.Black,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Bold,
            )

            Row {
                Text(
                    text = restaurant.displayDistance + " • ",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Left,
                )

                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    modifier = Modifier,
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(Color(0xFFFFFF00))
                )

                Text(
                    text = restaurant.rating.toString(),
                    fontSize = 15.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Left,
                )
            }

            if (restaurant.offers.isNotEmpty()) {
                val color = Color(parseColor("#${restaurant.offers[0].textColor}"))
                val backgroundColor = Color(parseColor("#${restaurant.offers[0].background}"))

                Row {
                    restaurant.offers.forEach { offer ->
                        Box(
                            modifier = Modifier
                                .padding(3.dp)
                                .background(
                                    color = backgroundColor,
                                    shape = RoundedCornerShape(8.dp)
                                ).border(1.dp, Color.Black, shape = RoundedCornerShape(8.dp))
                        ) {
                            Text(
                                text = offer.name,
                                color = color,
                            )
                        }
                    }
                }
            }
        }
    }
}
