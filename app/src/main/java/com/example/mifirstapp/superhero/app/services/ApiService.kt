package com.example.mifirstapp.superhero.app.services

import com.example.mifirstapp.superhero.app.SuperHeroResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/10229233666327556/search/{name}")
    suspend fun getSuperHeroList(@Path ("name") name: String): Response<SuperHeroResponse>
}