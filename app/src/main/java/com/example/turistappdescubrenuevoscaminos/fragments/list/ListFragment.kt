package com.example.turistappdescubrenuevoscaminos.fragments.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.turistappdescubrenuevoscaminos.databinding.FragmentListBinding
import com.example.turistappdescubrenuevoscaminos.list.PlaceAdapter
import com.example.turistappdescubrenuevoscaminos.main.MainActivity
import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModel
import com.example.turistappdescubrenuevoscaminos.model.PlaceItemModelCollection
import com.example.turistappdescubrenuevoscaminos.services.PlaceRepository
import com.google.gson.Gson

class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var placeAdapter: PlaceAdapter
    private var listPlaces: ArrayList<PlaceItemModel> = arrayListOf()
    private lateinit var listViewModel: ListViewModel

    private val repository = PlaceRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity?)?.hideIcon()

        /****************** JSON ******************************/
        //PLACES JSON

        //listViewModel.loadMockPlacesFromJson(context?.assets?.open("places.json"))
        listViewModel.loadPlacesFromServer()

        //listPlaces = loadMockFromJson()
        /*************************************************************/

        /****************   OBSERVABLE   **************************/
        listViewModel.onPlacesLoaded.observe(viewLifecycleOwner,{result ->
            onPlacesLoadedSubscribe(result)
        })
        /*************************************************************/

        placeAdapter = PlaceAdapter(listPlaces, onItemClicked = { onPlaceClicked(it) })


        listBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placeAdapter
            setHasFixedSize(false)
        }

    }

    private fun onPlacesLoadedSubscribe(result: ArrayList<PlaceItemModel>?) {

        result?.let { listPlaces ->
            placeAdapter.appendItems(listPlaces)
            /*
            // TODO: revisar feedback
            this.listSuperheroes = listSuperheroes
            superHeroesAdapter.notifyDataSetChanged()
            */
        }
    }

    private fun onPlaceClicked(it: PlaceItemModel) {
        //Log.d("alias",it.nombre)

        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(placeItem = it))
        //findNavController().navigate(ListFragmentDirections.actionNavigationListToNavigationPreference())
    }

    private fun loadMockFromJson(): ArrayList<PlaceItemModel> {
        val json: String = context?.assets?.open("places.json")?.bufferedReader().use { it!!.readText() }//TODO Reparar !!
        val gson = Gson()
        val jsonList = gson.fromJson(json, PlaceItemModelCollection::class.java)

        return jsonList
    }

}