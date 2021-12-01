package com.example.turistappdescubrenuevoscaminos.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.turistappdescubrenuevoscaminos.R
import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModel
import com.squareup.picasso.Picasso
import java.io.Serializable

class PlaceDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_detail)

        val placeItem : PlaceItemModel = intent.extras?.getSerializable("placeItem") as PlaceItemModel

        bindPlace(placeItem)


    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun bindPlace(placeItem : PlaceItemModel){
        val textView = findViewById<TextView>(R.id.titulo_text_view)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val txtCalificacion=findViewById<TextView>(R.id.txtCalificacion)
        val txtDescription = findViewById<TextView>(R.id.txtDescripcion)

        textView.text= placeItem.nombre
        txtCalificacion.text = placeItem.calificacion
        txtDescription.text=placeItem.descripcionExtensa

        //picture
        Picasso.get().load(placeItem.foto).into(imageView);
    }
}