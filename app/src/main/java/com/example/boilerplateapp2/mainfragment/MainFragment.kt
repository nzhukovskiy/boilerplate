package com.example.boilerplateapp2.mainfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.boilerplateapp2.ICityRetrofit
import com.example.boilerplateapp2.R
import com.example.boilerplateapp2.objects.CityRetrofitClient
import retrofit2.Retrofit

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.main_fragment, container, false)
        val main_text : TextView = root.findViewById(R.id.text_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.request_cities().observe(viewLifecycleOwner, {
            main_text.text = it[0].Country
        })


        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}