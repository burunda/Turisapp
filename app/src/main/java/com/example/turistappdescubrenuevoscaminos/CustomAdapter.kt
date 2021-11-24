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


class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

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
        var context = viewGroup.getContext()
        var packageName = context.packageName


        //var id = viewGroup.resources.getIdentifier("p_0.png","drawable",packageName)

        var json: String?
        try {
            val inputStream = context.assets.open("lugares.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            json= "[]"
        }
        var lista = JSONArray(json)

        val viewModelCollection = mutableListOf<PlaceViewModel>()

        for(i in 0 until lista.length()){
            var item = lista.getJSONObject(i)

            var viewModel:PlaceViewModel = PlaceViewModel(
                item.getString("nombre"),
                item.getString("descripcion"),
                item.getString("foto"),
                item.getString("calificacion"))

            viewModelCollection.add(viewModel)

            arraylist.add(viewModel)
        }


        var v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text=arraylist[i].nombre
        viewHolder.itemDetail.text=arraylist[i].descripcion
        var url = arraylist[i].calificacion;


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
        return 18
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