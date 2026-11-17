package com.example.mars_novrizal.data.api

import com.example.mars_novrizal.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}