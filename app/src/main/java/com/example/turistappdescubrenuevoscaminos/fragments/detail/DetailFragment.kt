package com.example.turistappdescubrenuevoscaminos.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.turistappdescubrenuevoscaminos.R
import com.example.turistappdescubrenuevoscaminos.databinding.FragmentDetailBinding
import com.example.turistappdescubrenuevoscaminos.main.MainActivity


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding

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


    }

}