package com.example.turistappdescubrenuevoscaminos
import com.google.gson.annotations.SerializedName

data class PlaceViewModel (
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("url_img")
    val foto: String,
    @SerializedName("calificacion")
    val calificacion:String
)