package com.example.turistappdescubrenuevoscaminos;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.IOException
import java.nio.charset.Charset


class CustomAdapter (
    private val placesList:MutableList<PlaceViewModel>
): RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    var arraylist = ArrayList<PlaceViewModel>()

    var titles= arrayOf<String>("Codelia2","Suscribete","Videos","Youtube")
    val details= arrayOf("Muchos videos nuevos","Kotlin","Mas videos","Gran cantidad de videos")
    val images= arrayOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground)

    init {
        //titles= arrayOf<String>("WTF","WTF","WTF","WTF")
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        var v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=placesList[i].nombre
        viewHolder.itemDetail.text=placesList[i].descripcion
        //var url = placesList[i].foto;


        var imagen = R.drawable.ic_launcher_foreground

        var logo = when(i){
            0 -> R.drawable.p_0
            1 -> R.drawable.p_1
            2 -> R.drawable.p_2
            3 -> R.drawable.p_3
            4 -> R.drawable.p_4
            5 -> R.drawable.p_5
            6 -> R.drawable.p_6
            7 -> R.drawable.p_7
            8 -> R.drawable.p_8
            9 -> R.drawable.p_9
            10 -> R.drawable.p_12
            11 -> R.drawable.p_11
            12 -> R.drawable.p_12
            13 -> R.drawable.p_13
            14 -> R.drawable.p_14
            15 -> R.drawable.p_15
            16 -> R.drawable.p_16
            17 -> R.drawable.p_17
            else -> R.drawable.ic_launcher_foreground
        }

        viewHolder.itemImage.setImageResource(logo)



    }

    override fun getItemCount(): Int {
        return placesList.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail:TextView

        init{
            itemImage=itemView.findViewById(R.id.item_image);
            itemTitle=itemView.findViewById(R.id.item_title);
            itemDetail=itemView.findViewById(R.id.item_detail)

        }
    }
}