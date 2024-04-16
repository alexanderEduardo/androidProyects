package com.example.mifirstapp.superhero.app

import com.google.gson.annotations.SerializedName

data class SuperHeroResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperHero>,
    @SerializedName("error") val error: String?
)

data class SuperHero(
    @SerializedName("id") val id :String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: SuperHeroImage)

data class SuperHeroImage(
    @SerializedName("url") val url: String
)

