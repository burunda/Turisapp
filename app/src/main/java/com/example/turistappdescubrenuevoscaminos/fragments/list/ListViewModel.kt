package com.example.turistappdescubrenuevoscaminos.fragments.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModel
import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModelCollection
import com.example.turistappdescubrenuevoscaminos.services.PlaceRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.http.Tag
import java.io.InputStream

class ListViewModel : ViewModel(){
    private var placesLoad : MutableLiveData<ArrayList<PlaceItemModel>> = MutableLiveData()
    val onPlacesLoaded : LiveData<ArrayList<PlaceItemModel>> = placesLoad

    private val repository = PlaceRepository()

    fun loadMockPlacesFromJson(inputStream: InputStream?) {
        val json = inputStream?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        placesLoad.value = gson.fromJson(json, PlaceItemModelCollection::class.java)
    }

    fun loadPlacesFromServer(){
        
        GlobalScope.launch(Dispatchers.IO) {
            placesLoad.postValue(repository.getPlaces())
        }
    }

}