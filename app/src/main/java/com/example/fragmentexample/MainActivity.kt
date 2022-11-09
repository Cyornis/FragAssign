package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener

//data tranfer between
//activity to fragment
//fragment to framgnet
//activity ka fragment to 2nd activity ka fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGrp = findViewById<RadioGroup>(R.id.rd_grp)
        val bundle = Bundle()
//        bundle.putString("name","ANJALI")
//        bundle.putInt("age",24)
        val manager=supportFragmentManager
        radioGrp.setOnCheckedChangeListener { group, checkedId ->

            when(checkedId){

                R.id.rd_btn1->{
                    //create first fragments
                    val firstfragment = FirstFragment()
                   // firstfragment.arguments = bundle
                    val firstFragmentobject = manager.beginTransaction()
                    firstFragmentobject.replace(R.id.fragment_container,firstfragment)
                    firstFragmentobject.commit()
                 //   Log.d("ANJALI", "if part ")
                }
                R.id.rd_btn2->{
                    //create 2nd fragment
                    val secondfragment =  SecondFragment()
                  //  secondfragment.arguments = bundle
                    val secondfragmentObject = manager.beginTransaction()
                    secondfragmentObject.replace(R.id.fragment_container,secondfragment)
                    secondfragmentObject.commit()
                  //  Log.d("ANJALI", "else part")
                }
            }
        }
        manager.setFragmentResultListener("data", this) { requestKey, bundle ->
                val result = bundle.getString("name")
                Toast.makeText(this,result,Toast.LENGTH_SHORT).show()
            }
      }
}