package com.example.turistappdescubrenuevoscaminos.list;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModel
import com.example.turistappdescubrenuevoscaminos.R
import com.squareup.picasso.Picasso


class PlaceAdapter (
    private val placesList:ArrayList<PlaceItemModel>,
    private val onItemClicked : (PlaceItemModel) -> Unit
): RecyclerView.Adapter<PlaceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val place = placesList[i]

        viewHolder.itemView.setOnClickListener {onItemClicked(placesList[i])}
        viewHolder.bind(place)
    }

    override fun getItemCount(): Int {
        return placesList.size
    }

    fun appendItems(newItems: ArrayList<PlaceItemModel>) {
        placesList.clear()
        placesList.addAll(newItems)
        notifyDataSetChanged()
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

        fun bind(placeItemModel: PlaceItemModel){
            //Log.d("url",placeViewModel.foto)

            itemTitle.text = placeItemModel.nombre
            itemDetail.text=placeItemModel.descripcion

            //picture
            Picasso.get().load(placeItemModel.foto).into(itemImage);
        }
    }
}