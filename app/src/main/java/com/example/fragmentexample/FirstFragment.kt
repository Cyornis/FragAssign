package com.example.fragmentexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  view =  inflater.inflate(R.layout.fragment_first,container,false)
        val nameET = view.findViewById<EditText>(R.id.name_et)
        val btn = view?.findViewById<Button>(R.id.btn_go)

        btn?.setOnClickListener {
            Log.d("ANJALI","Btn Clicked")
//            setFragmentResult("data", bundleOf("name" to result))
            val secondfragment =  SecondFragment()
            val bundle= Bundle()
            bundle.putString("name",nameET.text.toString())
            secondfragment.arguments = bundle

            val secondfragmentObject = parentFragmentManager.beginTransaction()
            secondfragmentObject.replace(R.id.fragment_container ,secondfragment)
            secondfragmentObject.commit()
        }
        return view
    }




}