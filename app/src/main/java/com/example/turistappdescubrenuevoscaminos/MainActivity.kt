package com.example.turistappdescubrenuevoscaminos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        val viewModelCollection = createMockPlaces()
        //**********************************************

        val placesAdapter = CustomAdapter(viewModelCollection)

        placesRecyclerView = findViewById(R.id.recyclerView)

        //apply simplifica la sintaxis
        //ejemplo
        /*
        * recyclerView.layoutManager = LinearLayoutManager(this)
        * recyclerView.adapter=adapter
        * por
        * recyclerView.apply{
        *   layoutManager= LinearLayoutManager(context)
            adapter = placesAdapter
        * }
        * */
        placesRecyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            adapter = placesAdapter
            setHasFixedSize(false)
        }

        /*val adapter = CustomAdapter(viewModelCollection)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter=adapter*/

        val textv = findViewById<TextView>(R.id.textView)

        textv.text = "Playas"

    }
    fun createMockPlaces(): MutableList<PlaceViewModel>{
        val placesJson =loadJSONFromAsset()

        var lista = JSONArray(placesJson)

        val viewModelCollection = mutableListOf<PlaceViewModel>()

        for(i in 0 until lista.length()){
            var item = lista.getJSONObject(i)

            var viewModel:PlaceViewModel = PlaceViewModel(
                item.getString("nombre"),
                item.getString("descripcion"),
                item.getString("url_img"),
                item.getString("calificacion"))

            viewModelCollection.add(viewModel)
        }

        return viewModelCollection
    }

    fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("places.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return "[/Error]"
        }
        return json
    }
}