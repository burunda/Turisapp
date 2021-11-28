package com.example.turistappdescubrenuevoscaminos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var placesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        //**********************************************
        //Load and Read places JSON
        val viewModelCollection = loadMockFromJson()
        //**********************************************

        val placesAdapter = PlaceAdapter(viewModelCollection)

        placesRecyclerView = findViewById(R.id.recyclerView)

        placesRecyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            adapter = placesAdapter
            setHasFixedSize(false)
        }

        val textv = findViewById<TextView>(R.id.textView)

        textv.text = "Playas"

    }


    private fun loadMockFromJson(): ArrayList<PlaceViewModel> {
        val json: String = applicationContext.assets.open("places.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val jsonList = gson.fromJson(json, PlaceViewModelCollection::class.java)

        return jsonList
    }
}