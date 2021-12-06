package com.example.tabapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val frg1 = LeftFragment()
        val frg2 = CenterFragment()
        val frg3 = RightFragment()
        //Top_Fragment frg=new Top_Fragment();//create the fragment instance for the top fragment
        //Middle_Fragment frg1=new Middle_Fragment();//create the fragment instance for the middle fragment
        // frg2=new Bottom_Fragment();//create the fragment instance for the bottom fragment

        val manager : FragmentManager = supportFragmentManager//create an instance of fragment manager

        val transaction : FragmentTransaction=manager.beginTransaction();//create an instance of Fragment-transaction

        transaction.add(R.id.left_frame, frg1, "Frag_Top_tag");
        transaction.add(R.id.center_frame, frg2, "Frag_Middle_tag");
        transaction.add(R.id.right_frame, frg3, "Frag_Bottom_tag");


        transaction.commit();
    }
}