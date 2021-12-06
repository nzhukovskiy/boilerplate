package com.example.wearmodule

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.wearmodule.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //super.onCreate(savedInstanceState)

        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login_btn : Button = this.findViewById(R.id.login_button)
        login_btn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {  }
            startActivity(intent)
            //val nav_frag = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            //val nav_controller = nav_frag.navController
            //nav_controller.navigate(R.id.action_firstFragment_to_secondFragment)
        }


    }
}