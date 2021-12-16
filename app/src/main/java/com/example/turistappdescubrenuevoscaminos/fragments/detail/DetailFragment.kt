package com.example.turistappdescubrenuevoscaminos.fragments.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.turistappdescubrenuevoscaminos.databinding.FragmentDetailBinding
import com.example.turistappdescubrenuevoscaminos.main.MainActivity


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailBinding  = FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = args.placeItem

        //Log.d("place",item.lat_lon[0]+"_"+item.lat_lon[1])

        with(detailBinding){
            tituloTextView2.text=item.nombre
            txtCalificacion2.text=item.calificacion
            txtDescripcion2.text=item.descripcionExtensa
            com.squareup.picasso.Picasso.get().load(item.foto).into(imageView2)
        }

    }

}