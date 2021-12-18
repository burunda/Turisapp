package com.example.turistappdescubrenuevoscaminos.services

class PlaceRepository {

    suspend fun getPlaces() = ApiFactory.retrofit.getPlaces()

}