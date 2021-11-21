package com.example.turistappdescubrenuevoscaminos;

import android.content.Context
import android.util.log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<RecyclerviewActivity>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {*/

data class CustomAdapter (
    private val mLugares: ArrayList<ItemsViewModel>,
    private val context: Context,
    private val onClick: (ItemsViewModel?) -> Unit
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugaresViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return LugaresViewHolder(view)
    }

    override fun onBindViewHolder(holderItemsViewModel: LugaresViewHolder, position: Int) {
        val ItemsViewModel = mLugares[position]
       holderLugares.bind(lugares = lugares)

    }

    override fun getItemCount():Int {
        return mLugares.size
    }

    inner class LugaresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var
    private var
    private var
    private var

    init {
        itemView.setOnClickListener {
            Log.d(TAG, "itemView OnClick")
            OnClick(current Lugares)
        }

        fun bind(lugares: Lugares) {
            currentLugares = lugares

            val
        }

    }
        
        /*val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textview)*/
    }

}