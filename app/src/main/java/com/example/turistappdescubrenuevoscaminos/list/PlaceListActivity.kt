package com.example.turistappdescubrenuevoscaminos.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.turistappdescubrenuevoscaminos.R
import com.example.turistappdescubrenuevoscaminos.detail.PlaceDetailActivity
import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModel
import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModelCollection
import com.google.gson.Gson

class PlaceListActivity : AppCompatActivity() {

    private lateinit var placesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this.supportActionBar?.hide()
        setContentView(R.layout.activity_place_list)

        //**********************************************
        //Load and Read places JSON
        val viewModelCollection = loadMockFromJson()
        //**********************************************

        val placesAdapter = PlaceAdapter(viewModelCollection, onItemClicked = { onPlaceClicked(it) })

        placesRecyclerView = findViewById(R.id.recyclerView)

        placesRecyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            adapter = placesAdapter
            setHasFixedSize(false)
        }

        val textv = findViewById<TextView>(R.id.textView)

        textv.text = "Playas"

    }

    private fun onPlaceClicked(it: PlaceItemModel) {
        Log.d("alias",it.nombre)

        val intent = Intent(this,PlaceDetailActivity::class.java)
        intent.putExtra("placeItem",it)

        startActivity(intent)


    }


    private fun loadMockFromJson(): ArrayList<PlaceItemModel> {
        val json: String = applicationContext.assets.open("places.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val jsonList = gson.fromJson(json, PlaceItemModelCollection::class.java)

        return jsonList
    }
}