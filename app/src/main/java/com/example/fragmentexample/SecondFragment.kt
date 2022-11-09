package com.example.fragmentexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener

class SecondFragment : Fragment(R.layout.fragment_second) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second,container,false)

        val name_tv = view?.findViewById<TextView>(R.id.name_tv)
        val name = arguments?.getString("name","data Not received")
        name_tv?.text = name
        // Inflate the layout for this fragment
        return view
    }

}