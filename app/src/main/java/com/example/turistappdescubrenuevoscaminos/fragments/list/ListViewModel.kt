package com.example.turistappdescubrenuevoscaminos.fragments.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModel
import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModelCollection
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel : ViewModel(){
    private var placesLoad : MutableLiveData<ArrayList<PlaceItemModel>> = MutableLiveData()
    val onPlacesLoaded : LiveData<ArrayList<PlaceItemModel>> = placesLoad

    fun loadMockPlacesFromJson(inputStream: InputStream?) {
        val json = inputStream?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        placesLoad.value = gson.fromJson(json, PlaceItemModelCollection::class.java)
    }

}