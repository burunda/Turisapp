package com.example.turistappdescubrenuevoscaminos;

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class PlaceAdapter (
    private val placesList:ArrayList<PlaceViewModel>
): RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val place = placesList[i]
        viewHolder.bind(place)
    }

    override fun getItemCount(): Int {
        return placesList.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        private var itemImage: ImageView
        private var itemTitle: TextView
        private var itemDetail:TextView

        init{
            itemImage    = itemView.findViewById(R.id.item_image)
            itemTitle    = itemView.findViewById(R.id.item_title)
            itemDetail   = itemView.findViewById(R.id.item_detail)
        }

        /*init{
            itemImage    = itemView.findViewById(R.id.item_image)
            itemTitle    = itemView.findViewById(R.id.name_text_view)
            itemDetail   = itemView.findViewById(R.id.alias_text_view)
        }*/



        fun bind(placeViewModel: PlaceViewModel){
            //Log.d("url",placeViewModel.foto)

            itemTitle.text = placeViewModel.nombre
            itemDetail.text=placeViewModel.descripcion

            //picture
            Picasso.get().load(placeViewModel.foto).into(itemImage);
        }
    }
}