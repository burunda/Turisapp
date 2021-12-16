package com.example.turistappdescubrenuevoscaminos.services

import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModelCollection
import retrofit2.http.GET

interface ApiService {

    @GET("places")
    suspend fun getPlaces(): PlaceItemModelCollection

}