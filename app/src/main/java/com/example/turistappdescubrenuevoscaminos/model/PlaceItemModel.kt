package com.example.turistappdescubrenuevoscaminos.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlaceItemModel (
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("descripcion_extensa")
    val descripcionExtensa: String,
    @SerializedName("url_img")
    val foto: String,
    @SerializedName("calificacion")
    val calificacion:String
) : Serializable