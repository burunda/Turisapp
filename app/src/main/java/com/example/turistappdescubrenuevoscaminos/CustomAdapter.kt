package com.example.turistappdescubrenuevoscaminos;

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    val nombre = arrayListOf<lugares_interes.json>()
    val descripcion = arrayListOf<lugares_interes.json>()
    val foto = arrayListOf<lugares_interes.json>()
    val calificacion = arrayListOf<lugares_interes.json>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_design, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder:ViewHolder, i: Int) {
        viewHolder.itemText.text = nombre[i]
        viewHolder.itemDetail.text = descripcion[i]
        viewHolder.itemImage.setImageResource = foto[i]
        viewHolder.itemText2.text = calificacion[i]
    }

    override fun getItemCount():Int {
        return nombre.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemText: TextView
        val itemDetail: TextView
        val itemImage: ImageView
        val itemText2: TextView

        init {

            itemText = itemView.findViewById(R.id.itemText)
            itemDetail = itemView.findViewById(R.id.itemText)
            itemImage = itemView.findViewById(R.id.imageview)
            itemText2 = itemView.findViewById(R.id.itemText)

        }

    }
}
