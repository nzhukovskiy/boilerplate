package com.example.wearmodule

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.wearmodule.databinding.ActivityMain2Binding

class MainActivity2 : Activity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val btn_news : Button = binding.firstBtn
        btn_news.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}