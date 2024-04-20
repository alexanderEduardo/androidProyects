package com.example.mifirstapp.superhero.app

import com.google.gson.annotations.SerializedName

class SuperHeroDetail(
    @SerializedName("response")val response: String,
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: Powerstats,
    @SerializedName("image") val image: SuperHeroImage,
    @SerializedName("biography") val biography: Biography
)

data class Powerstats(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("place-of-birth") val placeOfBirth: String,
    @SerializedName("publisher") val publisher: String
)
