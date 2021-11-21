package com.example.turistappdescubrenuevoscaminos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewActivity : AppCompatActivity() {
    override fun OnCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_recyclerview)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<lugares_interes.json>

        for (int i=0; i < jArray.lenght(); i++)
        {
            try {
                lugares_interes.json oneObject = jArray.getJSONObject(i);
                String oneObjectsItem = oneObject.getString("Nombre")
                String oneObjectsItem2 = oneObject.getString("Descripcion")
                String oneObjectsItem3 = oneObject.getString("Foto")
                String oneObjectsItem4 = oneObject.getString("Calificacion")
            }

        }

/*        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.ic_launcher_foreground, "Item" + i))
        }

        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter*/

/*    private lateinit var mList: ArrayList<ItemsViewModel>
    private lateinit var mAdapter: CustomAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        recycler = findViewById<RecyclerView>(R.id.recyclerview)
        setupRecyclerView()
        initDataFromeFile()

        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.ic_launcher_foreground, "Item" + i))
        }

        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

    }

    }

    private fun readLugaresInteresJsonFile(): String? {
        var lugaresString: String? = null
        try {
            val inputStream = assets.open("lugares_interes.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            lugaresString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return lugaresString
    }
*/
    }
}