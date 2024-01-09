package com.example.foodzz.data_classes

import com.google.gson.annotations.SerializedName

data class HomeViewState(
    @SerializedName("banners") val banners: List<Banner>?,
    @SerializedName("food_categories") val foodCategories: List<FoodCategory>?,
    @SerializedName("number_of_active_vouchers") val vouchersCount: Int,
    @SerializedName("offer_collections") val offerCollections: List<OfferCollection>?,
    @SerializedName("restaurant_collections") val restaurantCollections: List<RestaurantCollection>?
)

data class Banner(
    @SerializedName("image_url") val imageUrl: String?,
    val id: Int
)

data class FoodCategory(
    @SerializedName("name") val name: String,
    val id: Int,
    @SerializedName("icon") val icon: String
)

data class OfferCollection(
    val name: String,
    val id: Int,
    val image: String,
    @SerializedName("textcolor") val textColor: String,
    val background: String
)

data class RestaurantCollection(
    val name: String,
    val priority: Int,
    val restaurants: List<Restaurant>
)

data class Restaurant(
    val id: Int,
    val name: String,
    @SerializedName("display_distance") val displayDistance: String,
    val rating: Double,
    @SerializedName("image_url") val imageUrl: String,
    val offers: List<Offer>,
    @SerializedName("additional_offer") val additionalOffer: String?
)

data class Offer(
    val name: String,
    val id: Int,
    @SerializedName("textcolor") val textColor: String,
    val background: String
)