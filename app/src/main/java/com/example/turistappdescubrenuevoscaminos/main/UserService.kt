package com.example.turistappdescubrenuevoscaminos.main

import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("places")
    fun listPlaces(): Call<List<placesDataCollection>>
}

class placesDataCollection : ArrayList<UserDataCollectionItem>()

data class UserDataCollectionItem(
    val no: Int,
    val id_foto: String,
    val nombre: String,
    val descripcion: String,
    val descripcion_extensa: String,
    val url_img: String,
    val calificacion: Int,
    val lat_lon: lat_lon
)

data class lat_lon(
    val lat: Float,
    val lon: Float
)

